package Library_Management_System.dto.response;

import lombok.Data;

@Data
public class MemberResponse {

    private Long id;
    private String memberName;
    private String memberEmail;
    private Long memberPhone;
    private String memberAddress;


}
