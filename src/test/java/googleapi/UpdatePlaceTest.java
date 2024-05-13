package googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import restapi.api.module.googleapi.GoogleAPIAddPlace;
import restapi.api.module.googleapi.GoogleAPIUpdatePlace;
import restapi.api.response.googleapi.GoogleAPIResponse;

public class UpdatePlaceTest {
    @Test()
    public void validateUpdatePlaceAPI() throws JsonProcessingException{
        GoogleAPIAddPlace googleAPIAddPlace = new GoogleAPIAddPlace();
        GoogleAPIResponse.AddPlaceResponse addPlaceResponse = googleAPIAddPlace.getAddPlaceResponse();
        String placeId = addPlaceResponse.getPlace_id();
        String newAddress = "Lakshmi Madhav residency";
        GoogleAPIUpdatePlace googleAPIUpdatePlace = new GoogleAPIUpdatePlace();
        GoogleAPIResponse.UpdatePlaceResponse updatePlaceResponse = googleAPIUpdatePlace.getUpdatePlaceResponse(placeId,newAddress);
        String message = updatePlaceResponse.getMsg();
        Assert.assertEquals("Address successfully updated",message);
    }
}
