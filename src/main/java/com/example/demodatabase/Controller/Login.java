package com.example.demodatabase.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class Login {

    @GetMapping("/login")
    private String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    private String loginCheck(String username, String password){
        return "redirect:/list";
    }

}
