package com.sammy.budgettracker.utils;

import com.sammy.budgettracker.data.models.User;
import com.sammy.budgettracker.dtos.requests.RegisterUserRequest;
import com.sammy.budgettracker.dtos.responses.RegisterUserResponse;


public class Mapper {
    public static User map(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }

    public static RegisterUserResponse map(User user) {
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setUsername(user.getUsername());
        return response;
    }
}
