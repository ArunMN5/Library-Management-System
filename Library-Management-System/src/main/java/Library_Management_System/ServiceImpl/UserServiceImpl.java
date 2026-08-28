package Library_Management_System.ServiceImpl;

import Library_Management_System.dto.Request.LoginRequest;
import Library_Management_System.dto.Request.RegisterRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.entity.User;
import Library_Management_System.repository.UserRepository;
import Library_Management_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Response register(RegisterRequest registerRequest) {

        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()){
            return new Response("UserName already exists",false,HttpStatus.NOT_FOUND,null);
        }

        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            return new Response("Email already exists",false,HttpStatus.NOT_FOUND,null);
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setRole("USER");
        userRepository.save(user);

        return new Response("registered succesfully",true, HttpStatus.CREATED,null);
    }

    @Override
    public Response login(LoginRequest loginRequest) {

        User user = new User();



        return null;
    }
}
