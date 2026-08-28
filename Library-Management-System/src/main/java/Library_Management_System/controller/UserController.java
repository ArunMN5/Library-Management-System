package Library_Management_System.controller;

import Library_Management_System.dto.Request.LoginRequest;
import Library_Management_System.dto.Request.RegisterRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest registerRequest) {
        Response response = userService.register(registerRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("login")
    public Response login(@RequestBody LoginRequest loginRequest) {
        Response response = userService.login(loginRequest);
        return response;
    }



}
