package Library_Management_System.dto.Request;

import lombok.Data;

import java.util.Date;

@Data
public class BookIssueRequest {

    private Long bookId;
    private Long memberId;
    private Date dueDate;

}
