package restapi.api.wrapper.getbookapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import restapi.api.response.bookapi.BookAPIAuthentication;
import restapi.api.response.bookapi.BookAPIResponse;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetBookAPI {

    ObjectMapper objectMapper = new ObjectMapper();
    public void setBaseURL(String url){
        RestAssured.baseURI = url;
    }

    public BookAPIAuthentication callAPI(HashMap<String,String> map, String resource) throws JsonProcessingException {
        String response = given().log().all().formParams(map).when().post(resource).then().log().all().extract().response().asString();
        return objectMapper.readValue(response, BookAPIAuthentication.class);
    }

    public BookAPIResponse callAPI(String resource, String sessionId) throws JsonProcessingException {
        String response = given().log().all().queryParam("access_token",sessionId).when().get(resource).then().log().all().extract().response().asString();
        return objectMapper.readValue(response, BookAPIResponse.class);
    }
}
