package br.com.certvision.service;

import br.com.certvision.domain.mapper.UserMapper;
import br.com.certvision.domain.model.Company;
import br.com.certvision.domain.model.User;
import br.com.certvision.domain.request.RegisterRequest;
import br.com.certvision.domain.response.UserResponse;
import br.com.certvision.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    //TODO implementar mapper
    public void register(RegisterRequest request, Company company) {
        User user = new User();
        user.setFullName(request.fullName());
        user.setEmail(request.email());
        user.setEmail_verified(false);
        user.setRole("ADMIN");
        user.setCompany(company);
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }

    public List<UserResponse> getUsersList() {

        List<UserResponse> responses = new ArrayList<>();
        userRepository.findAll()
                .forEach(user -> responses.add(userMapper.entityToResponse(user)));

        return responses;

    }

    public Optional<User> getByUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
