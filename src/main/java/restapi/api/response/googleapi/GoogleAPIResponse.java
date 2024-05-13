package restapi.api.response.googleapi;

import lombok.Data;

@Data
public class GoogleAPIResponse {
    @Data
    public static class AddPlaceResponse {
        private String status;
        private String place_id;
        private String scope;
        private String reference;
        private String id;
    }

    @Data
    public static class UpdatePlaceResponse {
        private String msg;
    }

    @Data
    public static class DeletePlaceResponse {
        private String status;
    }

    @Data
    public static class GetPlaceResponse {
        private Location location;
        @Data
        public static class Location {
            private String latitude;
            private String longitude;
        }
        private String accuracy;
        private String name;
        private String phone_number;
        private String address;
        private String types;
        private String website;
        private String language;
    }
}
