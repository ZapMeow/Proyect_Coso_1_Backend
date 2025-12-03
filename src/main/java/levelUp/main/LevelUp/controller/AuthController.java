package levelUp.main.LevelUp.controller;

import levelUp.main.LevelUp.model.User;
import levelUp.main.LevelUp.security.jwt.JwtService;
import levelUp.main.LevelUp.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserService userService;

    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserService userService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllCLients(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        try {
            System.out.println("making a user");

            String username = body.get("username");
            String password = body.get("password");
            String role = body.getOrDefault("role", "USER");
            String email = body.getOrDefault("email", "");
            String typeUser = body.getOrDefault("typeUser", "");
            int points = Integer.parseInt(body.getOrDefault("points", "0"));
            String range = body.getOrDefault("range", "NONE");
            boolean isPremium = "duocuc".equalsIgnoreCase(typeUser);

            if (username == null || password == null || username.isBlank() || password.isBlank()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "Username y password son requeridos"));
            }

            if (!role.equals("USER") && !role.equals("ADMIN")) {
                role = "USER";
            }

            userService.register(username, password, role, email, typeUser, points, range, isPremium);

            return ResponseEntity.ok(Map.of(
                    "message", "Usuario registrado correctamente",
                    "role", role
            ));

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El usuario ya existe"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno: " + e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            String username = body.get("username");
            String password = body.get("password");

            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            if (auth.isAuthenticated()) {
                // Obtener rol del usuario
                User user = userService.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

                String token = jwtService.generateToken(username, user.getRole());

                System.out.println(Map.of(
                        "token", token,
                        "username", username,
                        "role", user.getRole(), // Devolver rol
                        "user", user));

                return ResponseEntity.ok(Map.of(
                        "token", token,
                        "username", username,
                        "role", user.getRole(),
                        "premium", user.isPremium(),
                        "points", user.getPoints(),
                        "range", user.getRange(),
                        "email", user.getEmail()
                ));
            }
            System.out.println("invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales inválidas"));

        } catch (BadCredentialsException e) {
            System.out.println("user or password incorrect");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)

                    .body(Map.of("error", "Usuario o contraseña incorrectos"));
        } catch (Exception e) {
            System.out.println("error with the request");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al procesar la solicitud"));
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken() {
        return ResponseEntity.ok(Map.of("valid", true));
    }
}
