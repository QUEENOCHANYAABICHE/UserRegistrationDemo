package com.example.userregesterationdemo.Registeration;

import org.hibernate.annotations.NaturalId;

public record RegisterationRequest(
    String firstName,
    String lastName,
    String email,
    String password,
    String role){

    }


