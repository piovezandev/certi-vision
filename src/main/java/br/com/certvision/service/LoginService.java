package br.com.certvision.service;

import br.com.certvision.exceptions.ForbiddenException;
import br.com.certvision.domain.request.LoginRequest;
import br.com.certvision.domain.response.LoginResponse;
import br.com.certvision.security.JwtService;
import br.com.certvision.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        Optional<User> user = userService.getByUserName(request.username());

        if (user.isPresent() && passwordEncoder.matches(request.password(), user.get().getPassword())) {
            return new LoginResponse(jwtService.generateToken(request.username()));
        }
        throw new ForbiddenException("Invalid username or password");
    }
}
