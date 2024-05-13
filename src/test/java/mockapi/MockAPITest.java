package mockapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import restapi.api.module.mockapi.MockAPIModule;
import restapi.api.response.mockapi.MockAPIResponse;

import java.io.IOException;


/**
 * When we don't have API to start thw ork, instead start the work once we got the API
 * we can start designing the mock API with the below method
 * In this way we start working along with the developers
 */
public class MockAPITest {
    @Test()
    public void validateMockAPI() throws IOException {
        MockAPIModule mockAPI = new MockAPIModule();
        MockAPIResponse mockAPIResponse = mockAPI.getMockAPIResponse();
        System.out.println(mockAPIResponse.toString());
        //Print No Of Courses Returned by API
        int size = mockAPIResponse.getCourses().size();
        System.out.println("No Of Courses: "+size);

        //Print Purchase Amount
        int purchaseAmount = mockAPIResponse.getDashboard().getPurchaseAmount();
        System.out.println("Purchase Amount : "+purchaseAmount);

        //Title of the first course
        String title = mockAPIResponse.getCourses().get(0).getTitle();
        System.out.println("Title of the first course : "+title);

        int sum = 0;
        //Print all courses title and respective prices
        for(int i = 0; i<size; i++){
            System.out.println(mockAPIResponse.getCourses().get(i).getTitle());
            System.out.println(mockAPIResponse.getCourses().get(i).getPrice());
            sum += (mockAPIResponse.getCourses().get(i).getPrice()*mockAPIResponse.getCourses().get(i).getPrice());
        }

        //Print no of copies sold by RPA course
        for(int i = 0; i<size; i++){
            String titleRPA = mockAPIResponse.getCourses().get(i).getTitle();
            if(titleRPA.equals("RPA")){
                System.out.println(mockAPIResponse.getCourses().get(i).getCopies());
                break;
            }
        }

        //Check sum of all courses amount matches with the purchase amount
        if(sum == purchaseAmount){
            System.out.println("Sum of all courses amount matches with the purchase amount");
        }

    }
}
