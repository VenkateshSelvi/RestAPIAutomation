package googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import restapi.api.module.googleapi.GoogleAPIAddPlace;
import restapi.api.module.googleapi.GoogleAPIDeletePlace;
import restapi.api.response.googleapi.GoogleAPIResponse;

public class DeletePlaceTest {
    @Test()
    public void validateDeletePlaceAPI() throws JsonProcessingException {
        GoogleAPIAddPlace googleAPIAddPlace = new GoogleAPIAddPlace();
        GoogleAPIResponse.AddPlaceResponse addPlaceResponse = googleAPIAddPlace.getAddPlaceResponse();
        String placeId = addPlaceResponse.getPlace_id();
        GoogleAPIDeletePlace googleAPIDeletePlace = new GoogleAPIDeletePlace();
        GoogleAPIResponse.DeletePlaceResponse deletePlaceResponse = googleAPIDeletePlace.getDeletePlaceResponse(placeId);
        String status = deletePlaceResponse.getStatus();
        Assert.assertEquals(status,"OK");
    }
}
