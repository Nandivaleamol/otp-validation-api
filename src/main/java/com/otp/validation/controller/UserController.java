package com.otp.validation.controller;

import com.otp.validation.entity.User;
import com.otp.validation.helper.Message;
import com.otp.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    // handler for registration
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindResult,
                           @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session ) {

        try {
            if (!agreement) {
                System.out.println("You have not agreed terms and conditions.");
                throw new Exception("You have not agreed terms and conditions.");
            }
            if (bindResult.hasErrors()) {
                System.out.println("ERROR : "+bindResult.toString());
                model.addAttribute("user",user);
                System.out.println("Register page error");
                return "register";

            }
            user.setEnabled(true);

            //encoding password
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            System.out.println("Agreement : " + agreement);
            user.setEmail(session.getAttribute("email").toString());
            user.setRole("USER");
            User result = userRepository.save(user);
            System.out.println(result);
            model.addAttribute("user",user);
            session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
            return "user-profile";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message",new Message("Something went wrong!! "+ e.getMessage() , "alert-danger"));
            return "register";
        }
    }
}
