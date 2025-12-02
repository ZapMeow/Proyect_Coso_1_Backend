package levelUp.main.LevelUp.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // "ADMIN" o "USER"

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String typeUser;

    @Column(nullable = false)
    private int points;

    @Column(nullable = false)
    private String range;

    @Column(nullable = false)
    private boolean isPremium;

}
