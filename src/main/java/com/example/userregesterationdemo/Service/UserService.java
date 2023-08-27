package com.example.userregesterationdemo.Service;

import com.example.userregesterationdemo.Registeration.RegisterationRequest;
import com.example.userregesterationdemo.User.User;

import java.util.List;
import java.util.Optional;



public interface UserService {
    List<com.example.userregesterationdemo.User.User> getUsers();
    com.example.userregesterationdemo.User.User registerUser(RegisterationRequest request);
    Optional<User> findByEmail(String email);


}
