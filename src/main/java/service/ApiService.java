package service;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;

public class ApiService {
    private RequestSpecification requestBuild;
    private ResponseSpecification responseSpec;

    public ApiService(String uri) {
        requestBuild = new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();


        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = requestBuild;
        RestAssured.responseSpecification = responseSpec;
    }


    public RequestSpecification getRequestBuild() {
        return requestBuild;
    }

    public ResponseSpecification getResponseSpec() {
        return responseSpec;
    }
}
