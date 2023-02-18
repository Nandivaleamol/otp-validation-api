package com.otp.validation.controller;

import com.otp.validation.entity.User;
import com.otp.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/send-otp")
    public String home(Model model) {
        model.addAttribute("title", "Home- User Management");
        return "send-otp";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/profile")
    public String userProfile(@RequestParam("email")String email, Model model, HttpSession session){

        session.setAttribute("email",email);
        System.out.println(email);

        User user = this.userRepository.getUserByUserName(email);

        if (user==null){
            session.setAttribute("message", "User does not exist with this email!!");

            System.out.println("Login Home controller");
            return "login";
        }
        System.out.println("Home profile controller");
        model.addAttribute(user);
        return "user-profile";
    }


}