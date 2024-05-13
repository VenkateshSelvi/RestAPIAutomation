package restapi.api.module.mockapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import restapi.api.response.mockapi.MockAPIResponse;
import restapi.api.wrapper.mockapi.MockAPI;

import java.io.IOException;

public class MockAPIModule {
    public MockAPIResponse getMockAPIResponse() throws IOException {
        MockAPI mockAPI = new MockAPI();
        return mockAPI.callMockAPI();
    }
}
