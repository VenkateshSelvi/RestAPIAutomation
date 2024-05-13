package restapi.api.wrapper.mockapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import restapi.api.response.mockapi.MockAPIResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MockAPI {
    ObjectMapper objectMapper = new ObjectMapper();
    public MockAPIResponse callMockAPI() throws IOException {
        String responseString = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\":910,\n" +
                "    \"website\":\"rashulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\":[\n" +
                "    {\n" +
                "      \"title\":\"Selenium Python\",\n" +
                "      \"price\":50,\n" +
                "      \"copies\":6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\":\"Cypress\",\n" +
                "      \"price\":40,\n" +
                "      \"copies\":4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\":\"Rest Assured\",\n" +
                "      \"price\":45,\n" +
                "      \"copies\":10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String response = new String(Files.readAllBytes(Paths.get("/Users/vshankar/Downloads/JsonBody.json")));
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        return objectMapper.readValue(response, MockAPIResponse.class);
    }
}
