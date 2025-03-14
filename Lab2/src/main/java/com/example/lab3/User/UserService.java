package com.example.lab3.User;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UserService {
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
