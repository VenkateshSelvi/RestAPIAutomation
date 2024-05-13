package OAuth;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;
import restapi.api.module.bookapi.GetBook;
import restapi.api.response.bookapi.BookAPIAuthentication;
import restapi.api.response.bookapi.BookAPIResponse;

import java.util.HashMap;

public class OAuthPractice {
    GetBook getBook = new GetBook();
    @Test
    public void validateAuthenticationResponse() throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
        map.put("client_secret","erZOWM9g3UtwNRj340YYaK_W");
        map.put("grant_type","client_credentials");
        map.put("scope","trust");
        String baseURL = "https://rahulshettyacademy.com";
        String resource = "/oauthapi/oauth2/resourceOwner/token";
        BookAPIAuthentication bookAPIAuthentication = getBook.getBookAPIAuthenticationResponse(map, resource, baseURL);
        System.out.println(bookAPIAuthentication.getAccess_token());
        System.out.println(bookAPIAuthentication.getScope());
        System.out.println(bookAPIAuthentication.getExpires_in());
        System.out.println(bookAPIAuthentication.getRefresh_token());
        System.out.println(bookAPIAuthentication.getToken_type());
    }

    @Test
    public void validateBookAPIResponse() throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
        map.put("client_secret","erZOWM9g3UtwNRj340YYaK_W");
        map.put("grant_type","client_credentials");
        map.put("scope","trust");
        String baseURL = "https://rahulshettyacademy.com";
        String resource = "/oauthapi/oauth2/resourceOwner/token";
        GetBook getBook = new GetBook();
        BookAPIAuthentication bookAPIAuthentication = getBook.getBookAPIAuthenticationResponse(map, resource, baseURL);
        String resource2 = "oauthapi/getCourseDetails";
        String token = bookAPIAuthentication.getAccess_token();
        BookAPIResponse bookAPIResponse = getBook.getBookResponse(resource2, baseURL, token);
        System.out.println(bookAPIResponse.getLinkedIn());
        System.out.println(bookAPIResponse.getCourses().getMobile().get(0).getCourseTitle());
    }
}
