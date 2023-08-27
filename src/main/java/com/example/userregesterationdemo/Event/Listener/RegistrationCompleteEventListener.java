package com.example.userregesterationdemo.Event.Listener;

import com.example.userregesterationdemo.Event.RegistrationCompleteEvent;
import com.example.userregesterationdemo.User.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Get the newly registered user
        User theUser = event.getUser();

        //Create a verification token for user
        String verificationToken = UUID.randomUUID().toString();

        //Save user verification token for user

        //Build the verification url to be sent
        String url = event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;

        //Send the email


    }
}
