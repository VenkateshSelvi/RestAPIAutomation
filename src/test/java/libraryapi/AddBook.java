package libraryapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restapi.api.module.libraryapi.LibraryAPIAddBook;
import restapi.api.response.libraryapi.LibraryAPIResponse;

import java.util.Map;
import java.util.Random;

/**
 * This methods are not working since there is some issue in the backend side,I have raised
 * this issue to RahulShetty academy, once its resolved we can start using this
 */
public class AddBook {
    @Test(dataProvider = "Book")
    public void validateAddBook(String isbn,String aisle) throws JsonProcessingException {
        LibraryAPIAddBook book = new LibraryAPIAddBook();
        Random rand = new Random();
        JsonPath jsonPath = book.getAddBookResponse("Selenium", "Venkatesh Shankar", isbn, aisle);
        System.out.println(jsonPath.get("Msg").toString());
        System.out.println(jsonPath.get("ID").toString());
    }

    @DataProvider(name="Book")
    public Object[][] getBookData(){
        Random rand = new Random();
        return new Object[][]{{"Shankar"+rand.nextInt(10000),""+rand.nextInt(10000)},
                {"Shankar"+rand.nextInt(10000),""+rand.nextInt(10000)}};
    }
}
