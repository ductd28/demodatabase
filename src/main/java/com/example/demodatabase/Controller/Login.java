package com.example.demodatabase.Controller;


import com.example.demodatabase.DAO.UserDAO;
import com.example.demodatabase.Entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class Login {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginCheck(Model model, String username, String password, HttpSession session){
        User user = userDAO.findByUsername(username);
        if (userDAO.existsByUsername(username) && password.equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "redirect:/list";
        } else {
            String error = "Wrong username or password. Try again!";
            model.addAttribute("error", error);
            return "login";
        }
    }

}
