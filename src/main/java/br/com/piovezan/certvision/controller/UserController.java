package br.com.piovezan.certvision.controller;

import br.com.piovezan.certvision.model.User;
import br.com.piovezan.certvision.request.UserRequest;
import br.com.piovezan.certvision.service.UserService;
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
    void create(@RequestBody UserRequest userRequest) {
        userService.create(userRequest);
    }

    @GetMapping("/users")
    List<User> getUser() {
        return userService.getUser();
    }
}
