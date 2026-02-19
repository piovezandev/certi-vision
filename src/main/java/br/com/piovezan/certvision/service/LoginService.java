package br.com.piovezan.certvision.service;

import br.com.piovezan.certvision.exceptions.ForbiddenException;
import br.com.piovezan.certvision.model.User;
import br.com.piovezan.certvision.request.LoginRequest;
import br.com.piovezan.certvision.response.LoginResponse;
import br.com.piovezan.certvision.security.JwtService;
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
