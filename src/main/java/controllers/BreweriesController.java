package controllers;



import static com.jayway.restassured.RestAssured.given;

public class BreweriesController {
    private final String searchPath = "breweries/search";

    public String searchBreweries(String query){
        return given()
                .basePath(searchPath)
                .queryParam("query",query)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .asString();
    }
}
