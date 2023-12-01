package mx.edu.utez.Banco.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest request) {
        return "Login from public endpoint";
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest request) {
        return "Register from public end";
    }
}
