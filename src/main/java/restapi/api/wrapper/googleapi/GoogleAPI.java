package restapi.api.wrapper.googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import restapi.api.request.googleapi.GoogleAPIRequest;
import restapi.api.response.googleapi.GoogleAPIResponse;
import static io.restassured.RestAssured.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;

public class GoogleAPI {
    String queryParamKey = "";
    String queryParamValue = "";
    ObjectMapper objectMapper = new ObjectMapper();
    String responseString = "";

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

    public void setBaseURL() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

    public GoogleAPIResponse.AddPlaceResponse callGoogleAPI(GoogleAPIRequest.AddPlaceClass googleAPIRequest, HashMap<String, String> header, HashMap<String, String> queryParam, String resource) throws JsonProcessingException {
        RequestSpecification response = given().log().all().queryParam(getQueryParamKey(queryParam), getQueryParamValue(queryParam)).headers(header).body(googleAPIRequest);
        responseString = response.post(resource).then().log().all().extract().response().asString();
        objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
        return objectMapper.readValue(responseString, GoogleAPIResponse.AddPlaceResponse.class);
    }

    public GoogleAPIResponse.DeletePlaceResponse callGoogleAPI(GoogleAPIRequest.DeletePlaceClass googleAPIRequest, HashMap<String, String> header, String resource) throws JsonProcessingException {
        RequestSpecification response = given().log().all().headers(header).body(googleAPIRequest);
        String responseStr = response.delete(resource).then().log().all().extract().response().asString();
        return objectMapper.readValue(responseStr, GoogleAPIResponse.DeletePlaceResponse.class);
    }

    public GoogleAPIResponse.GetPlaceResponse callGoogleAPI(HashMap<String, String> queryParam, HashMap<String, String> placeId, String resource) throws JsonProcessingException {
        String key = "";
        String value = "";
        for (Map.Entry<String, String> entry : placeId.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
        }
        responseString = given().log().all().queryParam(key,value).queryParam(getQueryParamKey(queryParam), getQueryParamValue(queryParam)).get(resource).then().log().all().extract().response().asString();
        objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
        return objectMapper.readValue(responseString, GoogleAPIResponse.GetPlaceResponse.class);
    }

    public GoogleAPIResponse.UpdatePlaceResponse callGoogleAPI(GoogleAPIRequest.UpdatePlaceClass googleAPIRequest, HashMap<String, String> queryParam, HashMap<String, String> header, String resource) throws JsonProcessingException {
        RequestSpecification response = given().log().all().queryParam(getQueryParamKey(queryParam), getQueryParamValue(queryParam)).headers(header).body(googleAPIRequest);
        responseString = response.put(resource).then().log().all().extract().response().asString();
        return objectMapper.readValue(responseString, GoogleAPIResponse.UpdatePlaceResponse.class);
    }
}
