package restapi.api.module.libraryapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import restapi.api.response.libraryapi.LibraryAPIResponse;
import restapi.api.wrapper.libraryapi.LibraryAPI;

import java.util.HashMap;

public class LibraryAPIGetBook {
    public JsonPath getBookDetails(HashMap<String, String> queryParam, String resource) throws JsonProcessingException {
        LibraryAPI libraryAPI = new LibraryAPI();
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type","Application/json");
        libraryAPI.setBaseURL();
        return libraryAPI.callAPI(queryParam, resource, header);
    }
}
