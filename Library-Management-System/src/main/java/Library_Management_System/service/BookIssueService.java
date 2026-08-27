package Library_Management_System.service;

import Library_Management_System.dto.Request.BookIssueRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.BookIssueResponse;

import java.util.List;

public interface BookIssueService {

    Response issueBook(BookIssueRequest request);

    Response getIssueById(Long issueId);

    List<BookIssueResponse> getAllIssues();

    List<BookIssueResponse> getIssuesByMember(Long memberId);

    List<BookIssueResponse> getIssuesByBook(Long bookId);


}
