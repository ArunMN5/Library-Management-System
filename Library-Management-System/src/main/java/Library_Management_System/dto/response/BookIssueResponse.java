package Library_Management_System.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BookIssueResponse {

    private Long issueId;
    private Long bookId;
    private Long memberId;
    private Date issueDate;
    private Date dueDate;
    private String status;

    private LocalDate returnDate;


}
