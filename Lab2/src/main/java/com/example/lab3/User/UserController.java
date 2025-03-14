package com.example.lab3.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private final UserService userService;
            public UserController (UserService userService){
        this.userService=userService;
            }

    @GetMapping()
    public List<User> getUsers(){
        return this.userService.getUsers();

    }

}
