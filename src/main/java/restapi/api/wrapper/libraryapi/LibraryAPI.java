package restapi.api.wrapper.libraryapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import restapi.api.request.libraryapi.LibraryAPIRequest;
import restapi.api.response.googleapi.GoogleAPIResponse;
import restapi.api.response.libraryapi.LibraryAPIResponse;

public class LibraryAPI {
    String queryParamKey = "";
    String queryParamValue = "";
    String responseString = "";
    ObjectMapper objectMapper = new ObjectMapper();
    public void setBaseURL() {
        RestAssured.baseURI = "http://216.10.245.166";
    }

    private String getQueryParamKey(HashMap<String, String> queryParam) {
        for (Map.Entry<String, String> entry : queryParam.entrySet()) {
            queryParamKey = entry.getKey();
        }
        return queryParamKey;
    }

    private String getQueryParamValue(HashMap<String, String> queryParam) {
        for (Map.Entry<String, String> entry : queryParam.entrySet()) {
            queryParamValue = entry.getValue();
        }
        return queryParamValue;
    }

    public JsonPath callAPI(LibraryAPIRequest.AddBook libraryAPIRequest, String resource, HashMap<String, String> header) throws JsonProcessingException {
        String response = given().log().all().headers(header).body(libraryAPIRequest).post(resource).then().log().all().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }

    public JsonPath callAPI(HashMap<String, String> queryParam, String resource, HashMap<String, String> header) throws JsonProcessingException {
        String response = given().log().all().headers(header).queryParam(getQueryParamKey(queryParam), getQueryParamValue(queryParam)).get(resource).then().log().all().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }

    public JsonPath callAPI(String resource, LibraryAPIRequest.DeleteBook deleteBook, HashMap<String, String> header) throws JsonProcessingException {
        String response = given().log().all().headers(header).body(deleteBook).get(resource).then().log().all().extract().response().asString();
        return new JsonPath(response);
    }
}
