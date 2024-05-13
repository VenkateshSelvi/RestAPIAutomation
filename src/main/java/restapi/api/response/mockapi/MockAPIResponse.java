package restapi.api.response.mockapi;

import lombok.Data;

import java.util.List;

@Data
public class MockAPIResponse {
    public Dashboard dashboard;
    public List<Courses> courses;
    @Data
    public static class Dashboard {
        private int purchaseAmount;
        private String website;
    }

    @Data
    public static class Courses {
        private String title;
        private int price;
        private int copies;
    }

}
