package levelUp.main.LevelUp.controller;

import levelUp.main.LevelUp.model.User;
import levelUp.main.LevelUp.security.jwt.JwtService;
import levelUp.main.LevelUp.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;


    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body){

        System.out.println("registrando");

        String username = body.get("username");
        String password = body.get("password");

        if (username == null || username.isBlank() ||
            password == null ||  username.isBlank()){
            System.out.println("no");
            throw new IllegalArgumentException("xd no user lmao");
        }

        userService.register(username, password);
        System.out.println("yes");
        return Map.of("Message", "positiveXd");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body){

        String username = body.get("username");
        String password = body.get("password");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(username);
            return Map.of("token", token);
        }
        throw new RuntimeException("credentialsn't");
    }

}
