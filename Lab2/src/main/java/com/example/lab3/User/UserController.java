package com.example.lab3.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @GetMapping()
    public List<User> getUsers(){
        return List.of(
                new User(
                        "1",
                        "user@gmail.com",
                        "Yousif",
                        "password",
                        "01091588965"

                )
        );
    }

}
