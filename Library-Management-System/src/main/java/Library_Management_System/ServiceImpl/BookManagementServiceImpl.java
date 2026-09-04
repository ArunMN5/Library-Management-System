package Library_Management_System.ServiceImpl;

import Library_Management_System.dto.Request.BookManagementRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.BookManagementResponse;
import Library_Management_System.entity.BookManagement;
import Library_Management_System.repository.BookManagementRepository;
import Library_Management_System.service.BookManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookManagementServiceImpl implements BookManagementService {

    private final BookManagementRepository bookManagementRepository;

    @Override
    public Response AddBooks(BookManagementRequest bookManagementRequest) {

        BookManagement bookManagement = new BookManagement();

        // bookManagement.setId(bookManagementRequest.getId());
        bookManagement.setTitle(bookManagementRequest.getTitle());
        bookManagement.setAuthor(bookManagementRequest.getAuthor());
        bookManagement.setPrice(bookManagementRequest.getPrice());
        bookManagement.setQuantity(bookManagementRequest.getQuantity());
        bookManagement.setCategoryName(bookManagementRequest.getCategoryName());
        bookManagement.setPublishedDate(new Date());

        bookManagementRepository.save(bookManagement);

        BookManagementResponse response = new BookManagementResponse();

        response.setTitle(bookManagement.getTitle());
        response.setAuthor(bookManagement.getAuthor());
        response.setPublishedDate(bookManagement.getPublishedDate());

        return new Response("Book added", true, HttpStatus.CREATED, response);

    }

    @Override
    public Response GetBooksById(Long id) {

        List<BookManagement> books = bookManagementRepository.findAllById(id);
        return new Response("Books found", true, HttpStatus.OK, books);
    }

    @Override
    public Response UpdateBook(Long id,BookManagementRequest bookManagementRequest) {

        BookManagement bookManagement = bookManagementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book Not Found"));

        bookManagement.setTitle(bookManagementRequest.getTitle());
        bookManagement.setAuthor(bookManagementRequest.getAuthor());
        bookManagement.setPrice(bookManagementRequest.getPrice());
        bookManagement.setQuantity(bookManagementRequest.getQuantity());
        bookManagement.setCategoryName(bookManagementRequest.getCategoryName());

        bookManagementRepository.save(bookManagement);

        BookManagementResponse response = new BookManagementResponse();

        response.setTitle(bookManagement.getTitle());
        response.setAuthor(bookManagement.getAuthor());

        return new Response("Book updated", true, HttpStatus.OK, response);
    }

    @Override
    public Response DeleteBookById(Long id) {

        bookManagementRepository.deleteById(id);
        return new Response("Book deleted", true, HttpStatus.OK, null);
    }

}
