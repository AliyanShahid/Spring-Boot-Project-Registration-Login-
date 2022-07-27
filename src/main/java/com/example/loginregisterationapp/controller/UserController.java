package com.example.loginregisterationapp.controller;

import com.example.loginregisterationapp.entity.UserData;
import com.example.loginregisterationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public  String home()
    {
        return "index";

    }

    @GetMapping("/login")
    public  String loginuser()
    {
        return "Login";
    }

    @PostMapping("/register")
    public String register(UserData u, HttpSession session)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodepass= encoder.encode(u.getPassword());
        u.setPassword(encodepass);
        u.setRole("Role_User");
         repo.save(u);
        session.setAttribute("message","User Registered Successfully");
                 return "redirect:/";
    }

}
