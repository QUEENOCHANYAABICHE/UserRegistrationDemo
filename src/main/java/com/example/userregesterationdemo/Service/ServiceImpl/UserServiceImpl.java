package com.example.userregesterationdemo.Service.ServiceImpl;

import com.example.userregesterationdemo.DAO.UserDAO;
import com.example.userregesterationdemo.Exception.UserAlreadyExistsException;
import com.example.userregesterationdemo.Registeration.RegisterationRequest;
import com.example.userregesterationdemo.Service.UserService;
import com.example.userregesterationdemo.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder;

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public User registerUser(RegisterationRequest request) {
        Optional<User> user = this.findByEmail(request.email());
        if(user.isPresent()){
            throw new UserAlreadyExistsException("User with email "+ request.email() + " already exists");
        }
        var newUser = new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole(request.role());
        return userDAO.save(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
