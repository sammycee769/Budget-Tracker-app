package com.sammy.budgettracker.dtos.responses;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String username;
    private String id;
    private String email;
    private String phoneNumber;
}
