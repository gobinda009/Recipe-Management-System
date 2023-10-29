package com.gobinda.Recipe.Management.System.controllers;

import com.gobinda.Recipe.Management.System.models.Dto.AuthenticationInputDto;
import com.gobinda.Recipe.Management.System.models.Dto.SignInputDto;
import com.gobinda.Recipe.Management.System.models.User;
import com.gobinda.Recipe.Management.System.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;


    //sign up
    @PostMapping("user/signup")
    public String Signup(@Valid @RequestBody User user){
        return userService.signup(user);
    }

    @PostMapping("user/signin")
    public String SignIn(@Valid @RequestBody SignInputDto signInputDto){
        return userService.signin(signInputDto);
    }
    @DeleteMapping("user/signOut")
    public String userSignOut(@Valid @RequestBody AuthenticationInputDto auth)
    {
        return userService.userSignOut(auth);
    }

}
