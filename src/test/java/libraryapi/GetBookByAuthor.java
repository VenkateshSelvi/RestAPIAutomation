package libraryapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import restapi.api.module.libraryapi.LibraryAPIAddBook;
import restapi.api.module.libraryapi.LibraryAPIDeleteBook;
import restapi.api.module.libraryapi.LibraryAPIGetBook;
import restapi.api.response.libraryapi.LibraryAPIResponse;

import java.util.HashMap;
import java.util.Random;

public class GetBookByAuthor {
    Random rand = new Random();
    @Test
    public void validateGetBookByAuthor() throws JsonProcessingException {
        LibraryAPIAddBook book = new LibraryAPIAddBook();
        String authorName = "Venkatesh";
        JsonPath addBookResponse = book.getAddBookResponse("Selenium", authorName, "Shankar",""+rand.nextInt(3000));
        LibraryAPIGetBook getBook = new LibraryAPIGetBook();
        HashMap<String, String> queryParam = new HashMap<>();
        queryParam.put("AuthorName", authorName);
        JsonPath getBookResponse = getBook.getBookDetails(queryParam, "Library/GetBook.php");
        System.out.println(getBookResponse.get("book_name[0]").toString());
        System.out.println(getBookResponse.get("aisle[0]").toString());
        System.out.println(getBookResponse.get("isbn[0]").toString());
    }

    @Test
    public void validateGetBookById() throws JsonProcessingException {
        LibraryAPIAddBook book = new LibraryAPIAddBook();
        String authorName = "Venkatesh";
        JsonPath addBookResponse = book.getAddBookResponse("Selenium", authorName, "Shankar",""+rand.nextInt(3000));
        LibraryAPIGetBook getBook = new LibraryAPIGetBook();
        HashMap<String, String> queryParam = new HashMap<>();
        queryParam.put("ID", addBookResponse.get("ID"));
        JsonPath getBookResponse = getBook.getBookDetails(queryParam, "Library/GetBook.php");
        System.out.println(getBookResponse.get("book_name[0]").toString());
        System.out.println(getBookResponse.get("aisle[0]").toString());
        System.out.println(getBookResponse.get("isbn[0]").toString());
    }
}
