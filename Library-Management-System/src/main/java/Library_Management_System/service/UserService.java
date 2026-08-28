package Library_Management_System.service;

import Library_Management_System.dto.Request.LoginRequest;
import Library_Management_System.dto.Request.RegisterRequest;
import Library_Management_System.dto.Response;

public interface UserService {

    Response register(RegisterRequest registerRequest);

    Response login(LoginRequest loginRequest);
    
}
