package googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import restapi.api.module.googleapi.GoogleAPIAddPlace;
import restapi.api.response.googleapi.GoogleAPIResponse;

public class AddPlaceTest {
    @Test()
    public void validateAddPlaceAPI() throws JsonProcessingException {
        GoogleAPIAddPlace googleAPIAddPlace = new GoogleAPIAddPlace();
        GoogleAPIResponse.AddPlaceResponse addPlaceResponse = googleAPIAddPlace.getAddPlaceResponse();
        String status = addPlaceResponse.getStatus();
        String placeId =  addPlaceResponse.getPlace_id();
        Assert.assertEquals(status,"OK");
        System.out.println("Google Add Place API successfully added place and place Id is :" +placeId);
    }
}
