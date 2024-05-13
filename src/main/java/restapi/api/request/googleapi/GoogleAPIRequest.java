package restapi.api.request.googleapi;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class GoogleAPIRequest {
    @Data
    public static class AddPlaceClass {
        private int accuracy;
        private String name;
        private String phoneNumber;
        private String address;
        private List<String> types;
        private String website;
        private String language;
        private Location location;

        @Data
        public static class Location {
            private double lat;
            private double lng;
        }
    }

    @Data
    public static class UpdatePlaceClass {
        private String place_id;
        private String address;
        private String key;
    }

    @Data
    public static class DeletePlaceClass {
        private String place_id;
    }
}
