package restapi.api.module.googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import restapi.api.response.googleapi.GoogleAPIResponse;
import restapi.api.wrapper.googleapi.GoogleAPI;

import java.util.HashMap;

public class GoogleAPIGetPlace {
    public GoogleAPIResponse.GetPlaceResponse getGetPlaceResponse(String placeId) throws JsonProcessingException {
        GoogleAPIResponse.GetPlaceResponse response;
        GoogleAPI googleAPI = new GoogleAPI();
        String resource = "maps/api/place/get/json";
        HashMap<String, String> queryParamOne = new HashMap<>();
        queryParamOne.put("key","qaclick123");
        HashMap<String, String> queryParamTwo = new HashMap<>();
        queryParamTwo.put("place_id",placeId);
        googleAPI.setBaseURL();
        response = googleAPI.callGoogleAPI(queryParamOne, queryParamTwo, resource);
        return response;
    }
}
