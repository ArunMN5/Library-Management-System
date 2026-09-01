package Library_Management_System.service;

import Library_Management_System.dto.Request.BookManagementRequest;
import Library_Management_System.dto.Response;

//@Service
public interface BookManagementService {

    Response AddBooks(BookManagementRequest bookManagementRequest);

    Response DeleteBookById(Long id);

    Response UpdateBook(Long id,BookManagementRequest bookManagementRequest);

    Response GetBooksById(Long id);

}
