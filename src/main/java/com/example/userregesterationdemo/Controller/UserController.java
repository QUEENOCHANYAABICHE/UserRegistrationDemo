package com.example.userregesterationdemo.Controller;

import com.example.userregesterationdemo.Service.UserService;
import com.example.userregesterationdemo.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<User> getUsers(){
      return userService.getUsers();
    }

    @PostMapping("")
    public
}
