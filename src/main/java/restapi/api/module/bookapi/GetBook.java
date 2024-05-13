package restapi.api.module.bookapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import restapi.api.response.bookapi.BookAPIAuthentication;
import restapi.api.response.bookapi.BookAPIResponse;
import restapi.api.wrapper.getbookapi.GetBookAPI;

import java.util.HashMap;

public class GetBook {
    GetBookAPI getBookAPI = new GetBookAPI();
    public BookAPIAuthentication getBookAPIAuthenticationResponse(HashMap<String, String> map, String resource, String baseURL) throws JsonProcessingException {
        getBookAPI.setBaseURL(baseURL);
        return getBookAPI.callAPI(map,resource);
    }

    public BookAPIResponse getBookResponse(String resource, String baseURL, String sessionId) throws JsonProcessingException {
        getBookAPI.setBaseURL(baseURL);
        return getBookAPI.callAPI(resource, sessionId);
    }
}
