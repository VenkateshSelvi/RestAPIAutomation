package restapi.api.response.bookapi;

import lombok.Data;

@Data
public class BookAPIAuthentication {
    private String access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private String scope;
}
