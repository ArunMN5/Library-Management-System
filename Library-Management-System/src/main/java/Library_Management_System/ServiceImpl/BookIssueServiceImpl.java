package Library_Management_System.ServiceImpl;

import Library_Management_System.dto.Request.BookIssueRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.BookIssueResponse;
import Library_Management_System.entity.BookIssue;
import Library_Management_System.entity.BookManagement;
import Library_Management_System.entity.Member;
import Library_Management_System.exception.*;
import Library_Management_System.repository.BookIssueRepository;
import Library_Management_System.repository.BookManagementRepository;
import Library_Management_System.repository.MemberRepository;
import Library_Management_System.service.BookIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));

        if (book.getQuantity() <= 0) {
            throw new BookNotAvailableException("Book quantity less than 0");
        }

        BookIssue bookIssue = new BookIssue();

        bookIssue.setBook(book);
        bookIssue.setMember(member);
        bookIssue.setIssueDate(new Date());
        bookIssue.setDueDate(request.getDueDate());
        bookIssue.setStatus("Issued");

        book.setQuantity(book.getQuantity() - 1);
        bookManagementRepository.save(book);

        BookIssue savedIssue = bookIssueRepository.save(bookIssue);

        BookIssueResponse response = new BookIssueResponse();

        response.setIssueId(savedIssue.getId());
        response.setBookId(savedIssue.getBook().getId());
        response.setMemberId(savedIssue.getMember().getId());
        response.setIssueDate(savedIssue.getIssueDate());
        response.setDueDate(savedIssue.getDueDate());
        response.setStatus(savedIssue.getStatus());

        return new Response("book issused successfully", true, HttpStatus.CREATED, response);
    }

    @Override
    public Response getIssueById(Long issueId) {

        BookIssue bookIssue = bookIssueRepository.findById(issueId).orElseThrow(() ->
                new BookIssueNotFoundException("Book issue not found with id: " + issueId));

        BookIssueResponse response = new BookIssueResponse();

        response.setIssueId(bookIssue.getId());
        response.setBookId(bookIssue.getBook().getId());
        response.setMemberId(bookIssue.getMember().getId());
        response.setIssueDate(bookIssue.getIssueDate());
        response.setDueDate(bookIssue.getDueDate());
        response.setReturnDate(bookIssue.getReturnDate());
        response.setStatus(bookIssue.getStatus());

        return new Response("books fetched successfully", true, HttpStatus.OK, response);
    }

    @Override
    public List<BookIssueResponse> getAllIssues() {

        List<BookIssue> bookIssueResponses = (List<BookIssue>) bookIssueRepository.findAll();
        List<BookIssueResponse> bookIssueResponseList = new ArrayList<>();

        for (BookIssue bookIssue : bookIssueResponses) {

            BookIssueResponse bookIssueResponse = new BookIssueResponse();

            bookIssueResponse.setBookId(bookIssue.getBook().getId());
            bookIssueResponse.setMemberId(bookIssue.getMember().getId());
            bookIssueResponse.setIssueDate(bookIssue.getIssueDate());
            bookIssueResponse.setDueDate(bookIssue.getDueDate());
            bookIssueResponse.setStatus(bookIssue.getStatus());

            bookIssueResponseList.add(bookIssueResponse);

        }
        return bookIssueResponseList;
        // return new Response("fetched all issued details",true,HttpStatus.OK,bookIssueResponseList);

    }

    @Override
    public List<BookIssueResponse> getIssuesByMember(Long memberId) {

        List<BookIssue> bookIssues = (List<BookIssue>) bookIssueRepository.findByMemberId(memberId);
        List<BookIssueResponse> bookIssueResponseList = new ArrayList<>();

        for (BookIssue bookIssue : bookIssues) {

            BookIssueResponse bookIssueResponse = new BookIssueResponse();

            bookIssueResponse.setBookId(bookIssue.getBook().getId());
            bookIssueResponse.setMemberId(bookIssue.getMember().getId());
            bookIssueResponse.setIssueDate(bookIssue.getIssueDate());
            bookIssueResponse.setDueDate(bookIssue.getDueDate());
            bookIssueResponse.setStatus(bookIssue.getStatus());
            bookIssueResponse.setReturnDate(bookIssue.getReturnDate());
            bookIssueResponseList.add(bookIssueResponse);

        }
        return bookIssueResponseList;
    }

    @Override
    public List<BookIssueResponse> getIssuesByBook(Long bookId) {
        return List.of();
    }

    @Override
    public Response returnBook(Long issueId) {

        BookIssue bookIssue = bookIssueRepository.findById(issueId)
                .orElseThrow(() -> new BookIssueNotFoundException("Book issue not found"));

        if ("RETURNED".equals(bookIssue.getStatus())) {
            throw new BookAlreadyIssuedException("Book is already returned");
        }

        bookIssue.setReturnDate(LocalDate.now());
        bookIssue.setStatus("Returned");

        BookIssue saved = bookIssueRepository.save(bookIssue);

        BookIssueResponse response = new BookIssueResponse();
        response.setIssueId(saved.getId());
        response.setBookId(saved.getBook().getId());
        response.setMemberId(saved.getMember().getId());
        response.setIssueDate(saved.getIssueDate());
        response.setDueDate(saved.getDueDate());
        response.setReturnDate(saved.getReturnDate());
        response.setStatus(saved.getStatus());


        return new Response("book returned successfully", true, HttpStatus.OK, response);
    }
}
