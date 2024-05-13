package restapi.api.module.libraryapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.path.json.JsonPath;
import restapi.api.request.libraryapi.LibraryAPIRequest;
import restapi.api.response.libraryapi.LibraryAPIResponse;
import restapi.api.wrapper.libraryapi.LibraryAPI;

import java.util.HashMap;

public class LibraryAPIDeleteBook {
    public JsonPath getDeletePlaceResponse(String id) throws JsonProcessingException {
        LibraryAPIResponse.DeleteBookResponse addBookResponse;
        LibraryAPI libraryAPI = new LibraryAPI();
        String resource = "/Library/DeleteBook.php";
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type","Application/json");
        libraryAPI.setBaseURL();
        return libraryAPI.callAPI(resource, getDeleteBookRequest(id), header);
    }

    public LibraryAPIRequest.DeleteBook getDeleteBookRequest(String id){
        LibraryAPIRequest.DeleteBook deleteBook = new LibraryAPIRequest.DeleteBook();
        deleteBook.setId(id);
        return deleteBook;
    }

}
