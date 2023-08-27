package com.example.userregesterationdemo.Registeration;

import com.example.userregesterationdemo.Event.RegistrationCompleteEvent;
import com.example.userregesterationdemo.Service.UserService;
import com.example.userregesterationdemo.User.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/register")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    @PostMapping("")
    public String registerUser(RegisterationRequest registerationRequest, final HttpServletRequest request){
        User user = userService.registerUser(registerationRequest);
        //publish registration event
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Success! Please check your email to complete registration";
    }

     public String applicationUrl(HttpServletRequest request){
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

     }

}
