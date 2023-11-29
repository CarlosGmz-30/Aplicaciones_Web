package mx.edu.utez.Banco.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    //private final AuthService authService;

    @PostMapping(value = "/login")
    public String login(){
        return "Login from public endpoint";
    }


    @PostMapping(value = "/register")
    public String register(){
        return "Register from public endpoint";
    }
}
