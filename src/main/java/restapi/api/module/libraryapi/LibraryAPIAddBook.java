package restapi.api.module.libraryapi;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import restapi.api.request.libraryapi.LibraryAPIRequest;
import restapi.api.response.libraryapi.LibraryAPIResponse;
import restapi.api.wrapper.libraryapi.LibraryAPI;

import java.util.HashMap;

public class LibraryAPIAddBook {

    public JsonPath getAddBookResponse(String name, String author, String isbn, String aisle) throws JsonProcessingException {
        LibraryAPIResponse.AddBookResponse addBookResponse;
        LibraryAPI libraryAPI = new LibraryAPI();
        String resource = "Library/Addbook.php";
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        libraryAPI.setBaseURL();
        return libraryAPI.callAPI(getAddBookClass(name, author, isbn, aisle), resource, header);
    }

    public LibraryAPIRequest.AddBook getAddBookClass(String name, String author, String isbn, String aisle){
        LibraryAPIRequest.AddBook addBook = new LibraryAPIRequest.AddBook();
        addBook.setName(name);
        addBook.setAuthor(author);
        addBook.setIsbn(isbn);
        addBook.setAisle(aisle);
        return addBook;
    }
}
