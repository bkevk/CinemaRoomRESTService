package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Password {
    private String password;

    public String getPassword() {
        return password;
    }
}
