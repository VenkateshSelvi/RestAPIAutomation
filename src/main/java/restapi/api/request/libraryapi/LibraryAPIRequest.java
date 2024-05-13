package restapi.api.request.libraryapi;

import lombok.Data;

@Data
public class LibraryAPIRequest {
    @Data
    public static class AddBook{
        String name;
        String isbn;
        String aisle;
        String author;
    }

    @Data
    public static class DeleteBook{
        String id;
    }

}
