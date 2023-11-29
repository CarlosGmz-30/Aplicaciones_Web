package mx.edu.utez.Banco.auth;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String name;
    String firstName;
    String lastName;
    String country;

}
