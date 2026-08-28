package Library_Management_System.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginResponse {

    private String username;
    private String email;
    private String role;

}
