package libraryapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import restapi.api.module.libraryapi.LibraryAPIAddBook;
import restapi.api.module.libraryapi.LibraryAPIDeleteBook;
import restapi.api.response.libraryapi.LibraryAPIResponse;

import java.util.Random;


/**
 * This methods are not working since there is some issue in the backend side,I have raised
 * this issue to RahulShetty academy, once its resolved we can start using this
 */
public class DeleteBook {
    @Test
    public void validateDeleteBook() throws JsonProcessingException {
        Random rand = new Random();
        LibraryAPIAddBook addBook = new LibraryAPIAddBook();
        LibraryAPIDeleteBook deleteBook = new LibraryAPIDeleteBook();
        JsonPath addBookResponse = addBook.getAddBookResponse("Selenium", "Venkatesh Shankar", "Shankar","23041"+rand.nextInt(5000));
        JsonPath deleteBookResponse = deleteBook.getDeletePlaceResponse(addBookResponse.get("ID"));
        System.out.println(deleteBookResponse.get("Msg").toString());
    }
}
