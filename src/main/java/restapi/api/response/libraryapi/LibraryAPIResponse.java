package restapi.api.response.libraryapi;

import lombok.Data;
@Data
public class LibraryAPIResponse {
    @Data
    public static class AddBookResponse {
        String Msg;
        String ID;
    }

    @Data
    public static class GetBookDetails {
        String name;
        String isbn;
        String aisle;
    }

    @Data
    public static class DeleteBookResponse {
        String msg;
    }

}
