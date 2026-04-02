package com.sammy.budgettracker.services;

import com.sammy.budgettracker.data.models.User;
import com.sammy.budgettracker.data.repositories.UserRepo;
import com.sammy.budgettracker.dtos.requests.RegisterUserRequest;
import com.sammy.budgettracker.dtos.responses.RegisterUserResponse;
import com.sammy.budgettracker.exceptions.UserAlreadyExistsException;
import com.sammy.budgettracker.exceptions.UserNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.sammy.budgettracker.utils.Mapper.map;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


   public RegisterUserResponse registerUser (RegisterUserRequest request){
        validateUserDoesNotExist(request.getEmail());
        User user = map(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepo.save(user);
       return map(user);
   }

   public User getUserById(String id){
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
   }

    private void validateUserDoesNotExist(String email){
        Optional existingUser = userRepo.findByEmail(email);
        if(existingUser !=null && existingUser.isPresent()){
            throw new UserAlreadyExistsException(email + " is already registered");
        }
   }

}
