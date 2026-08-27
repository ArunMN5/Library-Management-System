package Library_Management_System.exception;

public class BookIssueNotFoundException extends RuntimeException {
    public BookIssueNotFoundException(String message) {
        super(message);
    }
}
