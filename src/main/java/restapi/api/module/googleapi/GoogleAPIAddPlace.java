package restapi.api.module.googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import restapi.api.request.googleapi.GoogleAPIRequest;
import restapi.api.response.googleapi.GoogleAPIResponse;
import restapi.api.wrapper.googleapi.GoogleAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoogleAPIAddPlace {

    public GoogleAPIResponse.AddPlaceResponse getAddPlaceResponse() throws JsonProcessingException {
        GoogleAPIResponse.AddPlaceResponse response;
        GoogleAPI googleAPI = new GoogleAPI();
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type","Application/json");
        HashMap<String, String> queryParam = new HashMap<>();
        queryParam.put("key","qaclick123");
        String resource = "maps/api/place/add/json";
        googleAPI.setBaseURL();
        response = googleAPI.callGoogleAPI(getAddPlaceClass(), header, queryParam, resource);
        return response;
    }
    private static GoogleAPIRequest.AddPlaceClass getAddPlaceClass() {
        GoogleAPIRequest.AddPlaceClass addPlaceClass = new GoogleAPIRequest.AddPlaceClass();
        GoogleAPIRequest.AddPlaceClass.Location location = new GoogleAPIRequest.AddPlaceClass.Location();
        location.setLat(38.383494);
        location.setLng(33.427362);
        addPlaceClass.setLocation(location);
        addPlaceClass.setAccuracy(50);
        addPlaceClass.setAddress("29, side layout, cohen 09");
        addPlaceClass.setLanguage("French-IN");
        addPlaceClass.setName("Frontline house");
        addPlaceClass.setPhoneNumber("(+91) 983 893 3937");
        addPlaceClass.setWebsite("http://google.com");
        List<String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        addPlaceClass.setTypes(list);
        return addPlaceClass;
    }
}
