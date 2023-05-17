package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Token {
    private String token;

    public String getToken() {
        return token;
    }
}
