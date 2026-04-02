package com.sammy.budgettracker.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message ="Password is required")
    private String password;
    @NotBlank(message = "Email is required")
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^(\\+234|0)(70|8[01]|9[01])[0-9]{8}$", message = "Invalid Nigerian phone number")
    private String phoneNumber;
}
