package Library_Management_System.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberRequest {

    @NotBlank(message = "Member name is required")
    private String memberName;

    @NotBlank(message = "Member email is required")
    @Email(message = "Invalid email format")
    private String memberEmail;

    @NotNull(message = "Member phone is required")
    private Long memberPhone;

    @NotBlank(message = "Member address is required")
    private String memberAddress;

}
