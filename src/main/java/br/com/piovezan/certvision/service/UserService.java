package br.com.piovezan.certvision.service;

import br.com.piovezan.certvision.model.Company;
import br.com.piovezan.certvision.model.User;
import br.com.piovezan.certvision.repository.UserRepository;
import br.com.piovezan.certvision.request.RegisterRequest;
import br.com.piovezan.certvision.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //TODO implementar mapper
    public void register(RegisterRequest request, Company company) {
        User user = new User();
        user.setUsername(request.fullName());
        user.setEmail(request.email());
        user.setEmail_verified(false);
        user.setRole("ADMIN");
        user.setCompany(company);
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Optional<User> getByUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
