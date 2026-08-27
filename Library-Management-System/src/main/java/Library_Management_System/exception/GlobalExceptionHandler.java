package Library_Management_System.exception;

import Library_Management_System.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookIssueNotFoundException.class)
    public Response handleBookIssueNotFoundException(BookIssueNotFoundException exception) {
        return new Response(exception.getMessage(), false, HttpStatus.NOT_FOUND, null);
    }

    @ExceptionHandler(BookAlreadyIssuedException.class)
    public Response handleBookAlreadyIssuedException(BookAlreadyIssuedException exception) {
        return new Response(exception.getMessage(), false, HttpStatus.NOT_FOUND, null);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public Response handleMemberNotFoundException(MemberNotFoundException exception) {
        return new Response(exception.getMessage(), false, HttpStatus.NOT_FOUND, null);
    }

    @ExceptionHandler(BookNotAvailableException.class)
    public Response handleBookNotAvailableException(BookNotAvailableException exception) {
        return new Response(exception.getMessage(), false, HttpStatus.NOT_FOUND, null);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public Response handleBookNotFoundException(BookNotFoundException exception) {
        return new Response(exception.getMessage(), false, HttpStatus.NOT_FOUND, null);
    }

}
