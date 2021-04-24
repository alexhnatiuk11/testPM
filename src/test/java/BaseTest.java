import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import service.ApiService;


public class BaseTest {
    protected ApiService apiService;
    protected ObjectMapper mapper;
    protected String openBreweryDbUri = "https://api.openbrewerydb.org/";

    @BeforeClass
    public void SetUp() {
        apiService = new ApiService(openBreweryDbUri);
        mapper = new ObjectMapper();
        RestAssured.urlEncodingEnabled = true;
    }
}
