package br.com.certvision.service;


import br.com.certvision.domain.model.Company;
import br.com.certvision.domain.model.User;
import br.com.certvision.domain.request.LoginRequest;
import br.com.certvision.domain.request.RegisterRequest;
import br.com.certvision.domain.response.AuthResponse;
import br.com.certvision.exceptions.ForbiddenException;
import br.com.certvision.security.JwtService;
import br.com.piovezan.certvision.exceptions.UserException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        Optional<User> user = userService.getByUserByEmail(request.username());
        if (user.isPresent() && passwordEncoder.matches(request.password(), user.get().getPassword())) {
            return new AuthResponse(jwtService.generateToken(user.get()));
        }
        throw new ForbiddenException("Invalid username or password");
    }

    @Transactional
    public void register(RegisterRequest request) {

        if (userService.getByUserByEmail(request.email()).isPresent()) {
            throw new UserException("Usuário já está cadastrado");
        }
        Company company = companyService.create(request);
        userService.register(request, company);


    }
}
