package restapi.api.module.googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import restapi.api.request.googleapi.GoogleAPIRequest;
import restapi.api.response.googleapi.GoogleAPIResponse;
import restapi.api.wrapper.googleapi.GoogleAPI;

import java.util.HashMap;

public class GoogleAPIDeletePlace {

    public GoogleAPIResponse.DeletePlaceResponse getDeletePlaceResponse(String placeId) throws JsonProcessingException {
        GoogleAPIResponse.DeletePlaceResponse response;
        GoogleAPI googleAPI = new GoogleAPI();
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type","Application/json");
        String resource = "maps/api/place/delete/json";
        googleAPI.setBaseURL();
        response = googleAPI.callGoogleAPI(getDeletePlaceClass(placeId), header, resource);
        return response;
    }
    private static GoogleAPIRequest.DeletePlaceClass getDeletePlaceClass(String placeId) {
        GoogleAPIRequest.DeletePlaceClass deletePlaceClass = new GoogleAPIRequest.DeletePlaceClass();
        deletePlaceClass.setPlace_id(placeId);
        return deletePlaceClass;
    }
}
