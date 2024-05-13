package restapi.api.response.bookapi;

import lombok.Data;

import java.util.List;

@Data
public class BookAPIResponse {
    private String instructor;
    private String url;
    private String services;
    private String expertise;
    private String linkedIn;
    private Courses courses;

    @Data
    public static class Courses{
        private List<WebAutomation> webAutomation;
        private List<Api> api;
        private List<Mobile> mobile;
        @Data
        public static class WebAutomation{
            String courseTitle;
            String price;
        }
        @Data
        public static class Api{
            String courseTitle;
            String price;
        }
        @Data
        public static class Mobile{
            String courseTitle;
            String price;
        }
    }
}
