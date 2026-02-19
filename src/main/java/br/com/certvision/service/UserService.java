package br.com.certvision.service;

import br.com.certvision.repository.UserRepository;
import br.com.certvision.domain.model.User;
import br.com.certvision.domain.request.UserRequest;
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

    public void create(UserRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Optional<User> getByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
