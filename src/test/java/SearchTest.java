import com.fasterxml.jackson.core.type.TypeReference;
import controllers.BreweriesController;
import models.BreweryModel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class SearchTest extends BaseTest {
    BreweriesController breweriesController = new BreweriesController();

    @Test(dataProvider = "dataProviderByAllFields")
    public void assertFullMatchedInAllFields(String searchParam, int expectedCount) throws IOException {
        String searchResponse = breweriesController.searchBreweries(searchParam);

        List<HashMap<String,String>> listOfBreweriesHashMaps = mapper.
                readValue(searchResponse, new TypeReference<List<HashMap<String,String>>>(){});

        String expectedText = searchParam.trim().toLowerCase();

        long actualCountOfMatchedText = listOfBreweriesHashMaps
                .parallelStream()
                .map(hashMap->hashMap.values().toString().toLowerCase())
                .filter(breweryValue -> breweryValue.contains(expectedText))
                .count();

         Assertions.assertThat(listOfBreweriesHashMaps.size())
                   .isEqualTo(actualCountOfMatchedText)
                   .isEqualTo(expectedCount);
    }

    @Test(dataProvider = "dataProviderByCertainFields")
    public void assertFullMatchedByCertainField(String searchParam, List<BreweryModel> expectedSearchedBreweriesList) throws IOException {
        String searchResponse = breweriesController.searchBreweries(searchParam);

        List<BreweryModel> actualSearchedBreweriesList = mapper.
                readValue(searchResponse, new TypeReference<List<BreweryModel>>(){});

        Assertions.assertThat(actualSearchedBreweriesList)
                  .isEqualTo(expectedSearchedBreweriesList);
    }

    @Test(dataProvider = "dataProviderByPartlyMatch")
    public void assertPartlyMatchedInAllFields(String searchParam, int expectedFullMatchedCount, int expectedPartlyMatchedCount) throws IOException {

        String searchResponse = breweriesController.searchBreweries(searchParam);

        List<HashMap<String,String>> listOfBreweriesHashMaps = mapper.
                readValue(searchResponse, new TypeReference<List<HashMap<String,String>>>(){});

        String expectedText = searchParam.trim().toLowerCase();

        long actualCountOfFullMatchedText = listOfBreweriesHashMaps
                .parallelStream()
                .map(hashMap->hashMap.values().toString().toLowerCase())
                .filter(breweryValue -> breweryValue.contains(expectedText))
                .count();

        Assertions.assertThat(listOfBreweriesHashMaps.size())
                .isEqualTo(expectedFullMatchedCount);

        Assertions.assertThat(actualCountOfFullMatchedText)
                .isEqualTo(expectedPartlyMatchedCount);
    }

    /**
     * @return Object[][] with params:
     * - searched text
     * - count of expected found object
     * ATTENTION Expected count of find breweries are hardcoded - in prod i would take this count from db.
     */
    @DataProvider(name = "dataProviderByAllFields")
    public Object[][] dataProviderByAllFields(){
        int countOfBreweryWithTripleText = 9;
        int countOfBreweryWithSantaRosaText = 18;
        return new Object[][]{
                              {"TRIPLE", countOfBreweryWithTripleText}, // upperCase text
                              {" triple ", countOfBreweryWithTripleText}, // Lower case and starts with spaces
                              {"SANTA rosa", countOfBreweryWithSantaRosaText}, // url encoded text with spaced
                              {"", 0}, // empty param - search must return empty array
                              {"textWithNoFoundsObject", 0} // with this param search must return empty array
                              };
    }

    /**
     * @return Object[][] with params:
     * - searched text
     * - expected object in search
     */
    @DataProvider(name = "dataProviderByCertainFields")
    public Object[][] dataProviderByCertainFields() throws IOException {
    URL breweryWithPostalCodeFile = getClass().getClassLoader().getResource("postalCodeJson.json");
    URL BreweryWithURLFile = getClass().getClassLoader().getResource("breweryWithUrlJson.json");
    URL BreweryWithPhoneFile = getClass().getClassLoader().getResource("phoneJson.json");

        List<BreweryModel> expectedBreweryWithPostalCode = mapper.readValue(breweryWithPostalCodeFile,
                new TypeReference<List<BreweryModel>>(){});
        List<BreweryModel> expectedBreweryWithURL = mapper.readValue(BreweryWithURLFile,
                new TypeReference<List<BreweryModel>>(){});
        List<BreweryModel> expectedBreweryWithPhone = mapper.readValue(BreweryWithPhoneFile,
                new TypeReference<List<BreweryModel>>(){});

        return new Object[][]{
                              {"98221-8682", expectedBreweryWithPostalCode}, // by postal_code
                              {"http://www.bigdogsbrews.com", expectedBreweryWithURL}, // by url
                              {"6095611762", expectedBreweryWithPhone}, // by phone (use number)
                              };
    }

    /**
     * @return Object[][] with params:
     * - searched text
     * - count of partly matched with text
     * - count of full matched with text
     */
    @DataProvider(name = "dataProviderByPartlyMatch")
    public Object[][] dataProviderByPartlyMatch(){
        int countOfFullMatchedWithDogText = 39;
        int countOfPartlyMatchedWithDogText = 49;
        int countOfFullMatchedWithLewisText = 10;
        int countOfPartlyMatchedWithLewisText = 18;
        return new Object[][]{
                {"Dog", countOfPartlyMatchedWithDogText, countOfFullMatchedWithDogText},
                {"Lewis", countOfPartlyMatchedWithLewisText, countOfFullMatchedWithLewisText},
                };
    }

}
