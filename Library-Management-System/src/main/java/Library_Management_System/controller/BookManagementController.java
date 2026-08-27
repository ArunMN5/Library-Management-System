package Library_Management_System.controller;

import Library_Management_System.dto.Request.BookManagementRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.service.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("libraryManagement")
public class BookManagementController {

    @Autowired
   private BookManagementService bookManagementService;

    @PostMapping("/addbooks")
    public ResponseEntity<Response> AddBooks(@RequestBody BookManagementRequest bookManagementRequest) {

        Response response = bookManagementService.AddBooks(bookManagementRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getBooksById/{id}")
    public ResponseEntity<Response> GetBooksById(@PathVariable Long id) {

        Response response = bookManagementService.GetBooksById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<Response> DeleteBookById(@PathVariable Long id) {

        Response response = bookManagementService.DeleteBookById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}