package br.com.certvision.controller;

import br.com.certvision.domain.request.RegisterRequest;
import br.com.certvision.domain.response.UserResponse;
import br.com.certvision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    void create(@RequestBody RegisterRequest userRequest) {
    }

    @GetMapping("/users")
    List<UserResponse> getUser() {
        return userService.getUsersList();
    }
}
