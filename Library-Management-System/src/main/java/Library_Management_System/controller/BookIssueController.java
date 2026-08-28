package Library_Management_System.controller;

import Library_Management_System.dto.Request.BookIssueRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.BookIssueResponse;
import Library_Management_System.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BookIssue")
public class BookIssueController {

    @Autowired
    private BookIssueService bookIssueService;

    @PostMapping("/issueDetails")
    public ResponseEntity<Response> issueBook(@RequestBody BookIssueRequest request) {
        Response response = bookIssueService.issueBook(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getBookIssueDetailsById/{issueId}")
    public ResponseEntity<List<BookIssueResponse>> getIssueById(@PathVariable Long issueId) {

        Response response = bookIssueService.getIssueById(issueId);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("getAllIssues")
    public ResponseEntity<List<BookIssueResponse>> getAllIssue() {
        List<BookIssueResponse> response = bookIssueService.getAllIssues();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getIssuesByMemberId/{memberId}")
    public ResponseEntity<List<BookIssueResponse>> getIssuesByMemberId(@PathVariable Long memberId) {
        List<BookIssueResponse> response = bookIssueService.getIssuesByMember(memberId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("retunrIssuedBook/{issueId}")
    public ResponseEntity<Response> returnBook(@PathVariable Long issueId) { // ,@RequestBody BookIssueRequest request

        Response response = bookIssueService.returnBook(issueId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
