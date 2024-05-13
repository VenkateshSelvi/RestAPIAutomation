package googleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import restapi.api.module.googleapi.GoogleAPIAddPlace;
import restapi.api.module.googleapi.GoogleAPIGetPlace;
import restapi.api.response.googleapi.GoogleAPIResponse;

public class GetPlaceTest {
    @Test()
    public void validateGetPlaceAPI() throws JsonProcessingException {
        GoogleAPIAddPlace googleAPIAddPlace = new GoogleAPIAddPlace();
        GoogleAPIResponse.AddPlaceResponse addPlaceResponse = googleAPIAddPlace.getAddPlaceResponse();
        String placeId =  addPlaceResponse.getPlace_id();
        GoogleAPIGetPlace googleAPIGetPlace = new GoogleAPIGetPlace();
        GoogleAPIResponse.GetPlaceResponse getPlaceResponse = googleAPIGetPlace.getGetPlaceResponse(placeId);
        String address = getPlaceResponse.getAddress();
        String website = getPlaceResponse.getWebsite();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(address,"29, side layout, cohen 09");
        softAssert.assertEquals(website,"http://google.com");
    }
}
