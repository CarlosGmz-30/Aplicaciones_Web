package mx.edu.utez.Banco.auth;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
}
