package mx.edu.utez.Banco.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String name;
    private String password;
    private String firstname;
    private String lastname;
    private String country;
}
