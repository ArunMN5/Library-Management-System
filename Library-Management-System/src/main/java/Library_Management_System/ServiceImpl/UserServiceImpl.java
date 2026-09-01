package Library_Management_System.ServiceImpl;
import Library_Management_System.dto.Request.LoginRequest;
import Library_Management_System.dto.Request.RegisterRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.entity.User;
import Library_Management_System.repository.UserRepository;
import Library_Management_System.security.JwtUtil;
import Library_Management_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public Response register(RegisterRequest registerRequest) {

        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return new Response("Username already exists", false, HttpStatus.CONFLICT, null);
        }

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return new Response("Email already exists", false, HttpStatus.CONFLICT, null);
        }

        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());

        userRepository.save(user);

        return new Response("Registered successfully", true, HttpStatus.CREATED, null);
    }

    @Override
    public Response login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        if (user == null) {
            return new Response("User not found", false, HttpStatus.NOT_FOUND, null);
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new Response("Wrong password", false, HttpStatus.UNAUTHORIZED, null);
        }

        //String token = jwtUtil.generateToken(user.getEmail());
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

        return new Response("Login successful", true, HttpStatus.OK, token);

    }
}
