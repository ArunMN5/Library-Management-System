package Library_Management_System.ServiceImpl;

import Library_Management_System.dto.Request.BookIssueRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.BookIssueResponse;
import Library_Management_System.entity.BookManagement;
import Library_Management_System.repository.BookIssueRepository;
import Library_Management_System.repository.BookManagementRepository;
import Library_Management_System.repository.MemberRepository;
import Library_Management_System.service.BookIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookIssueServiceImpl implements BookIssueService {

    private final BookIssueRepository bookIssueRepository;
    private final BookManagementRepository bookManagementRepository;
    private final MemberRepository memberRepository;


    @Override
    public Response issueBook(BookIssueRequest request) {
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
