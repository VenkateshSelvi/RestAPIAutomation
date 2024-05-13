package restapi.api.module.googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import restapi.api.request.googleapi.GoogleAPIRequest;
import restapi.api.response.googleapi.GoogleAPIResponse;
import restapi.api.wrapper.googleapi.GoogleAPI;

import java.util.HashMap;

public class GoogleAPIUpdatePlace {
    public GoogleAPIResponse.UpdatePlaceResponse getUpdatePlaceResponse(String placeId, String address) throws JsonProcessingException {
        GoogleAPIResponse.UpdatePlaceResponse response;
        GoogleAPI googleAPI = new GoogleAPI();
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type","Application/json");
        String resource = "maps/api/place/update/json";
        HashMap<String, String> queryParam = new HashMap<>();
        queryParam.put("key","qaclick123");
        googleAPI.setBaseURL();
        response = googleAPI.callGoogleAPI(getUpdatePlaceClass(placeId,address), queryParam, header, resource);
        return response;
    }

    private static GoogleAPIRequest.UpdatePlaceClass getUpdatePlaceClass(String placeId, String newAddress) {
        GoogleAPIRequest.UpdatePlaceClass updatePlaceClass = new GoogleAPIRequest.UpdatePlaceClass();
        updatePlaceClass.setPlace_id(placeId);
        updatePlaceClass.setAddress(newAddress);
        updatePlaceClass.setKey("qaclick123");
        return updatePlaceClass;
    }
}
