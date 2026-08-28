package Library_Management_System.dto.Request;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String role;

}
