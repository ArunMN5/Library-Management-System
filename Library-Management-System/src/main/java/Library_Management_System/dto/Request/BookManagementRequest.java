package Library_Management_System.dto.Request;

import lombok.Data;

@Data
public class BookManagementRequest {

    private Long id;
    private String title;
    private String author;
    private String categoryName;
    private double price;
    private int quantity;


}
