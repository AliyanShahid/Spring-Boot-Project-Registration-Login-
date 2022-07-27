package com.example.loginregisterationapp.controller;

import com.example.loginregisterationapp.entity.UserData;
import com.example.loginregisterationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/HomePage")
    public String home(Principal p , Model m)
    {
        String em = p.getName();
        UserData u = repo.findByEmail(em);
        m.addAttribute("fullname",u.getFullname());

        return"HomePage";
    }
}
