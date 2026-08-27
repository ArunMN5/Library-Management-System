package Library_Management_System.dto.response;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Data
public class BookManagementResponse {

    private String title;
    private String author;
    private Date publishedDate;

}
