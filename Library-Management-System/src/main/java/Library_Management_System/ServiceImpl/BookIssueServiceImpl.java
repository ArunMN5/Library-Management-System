package Library_Management_System.ServiceImpl;

import Library_Management_System.dto.Request.BookIssueRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.BookIssueResponse;
import Library_Management_System.entity.BookIssue;
import Library_Management_System.entity.BookManagement;
import Library_Management_System.entity.Member;
import Library_Management_System.repository.BookIssueRepository;
import Library_Management_System.repository.BookManagementRepository;
import Library_Management_System.repository.MemberRepository;
import Library_Management_System.service.BookIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookIssueServiceImpl implements BookIssueService {

    private final BookIssueRepository bookIssueRepository;
    private final BookManagementRepository bookManagementRepository;
    private final MemberRepository memberRepository;


    @Override
    public Response issueBook(BookIssueRequest request) {

        BookManagement book = bookManagementRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book quantity less than 0");
        }

        BookIssue bookIssue = new BookIssue();

        bookIssue.setBook(book);
        bookIssue.setMember(member);
        bookIssue.setIssueDate(new Date());
        bookIssue.setDueDate(request.getDueDate());
        bookIssue.setStatus("Issued");

        book.setQuantity(book.getQuantity() - 1);

        bookIssueRepository.save(bookIssue);

        BookIssue savedIssue = bookIssueRepository.save(bookIssue);

        BookIssueResponse response = new BookIssueResponse();

        response.setIssueId(savedIssue.getId());
        response.setBookId(savedIssue.getBook().getId());
        response.setMemberId(savedIssue.getMember().getId());
        response.setIssueDate(savedIssue.getIssueDate());
        response.setDueDate(savedIssue.getDueDate());
        response.setStatus(savedIssue.getStatus());

        return null;
    }

    @Override
    public Response getIssueById(Long issueId) {
        return null;
    }

    @Override
    public List<BookIssueResponse> getAllIssues() {
        return List.of();
    }

    @Override
    public List<BookIssueResponse> getIssuesByMember(Long memberId) {
        return List.of();
    }

    @Override
    public List<BookIssueResponse> getIssuesByBook(Long bookId) {
        return List.of();
    }
}
