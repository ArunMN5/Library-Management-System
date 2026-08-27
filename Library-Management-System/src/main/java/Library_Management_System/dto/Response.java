package Library_Management_System.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class Response {

    private String message;
    private boolean status;
    private HttpStatus httpStatus;
    private Object data;

    @Override
    public String toString() {
        return  "Response{" + "message=" + message + ", status=" + status + ", httpStatus=" + httpStatus + '}';
    }

    public Response(String message, boolean status, HttpStatus httpStatus, Object data) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
        this.data = data;
    }



}
