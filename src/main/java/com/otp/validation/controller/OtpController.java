package com.otp.validation.controller;

import com.otp.validation.entity.User;
import com.otp.validation.repository.UserRepository;
import com.otp.validation.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;
    private Random random = new Random(1000);

    @PostMapping("/send")
    public String sendOTP(@RequestParam("email") String email, HttpSession session) {

        // generating 4 digit OTP
        int otp = random.nextInt(999999);
        System.out.println("OTP " + otp);

        // code for send otp to email....
        String message = "OTP- " + otp;
        String subject = "OTP From Verify OTP";
        String to = email;
        boolean flag = this.emailService.sendEmail(message, subject, to);

        if (flag) {
            System.out.println("OTP "+otp);
            session.setAttribute("otp", otp);
            session.setAttribute("email", email);
            return "validate-otp";
        } else {
            session.setAttribute("message", "Check Your Email Id !!");
            return "validate-otp";
        }

    }

    @PostMapping("/validate")
    public String verifyOtp(@RequestParam("otp") int otp, Model model, HttpSession session) {

        int myOtp = (int) session.getAttribute("otp");
        String email = (String) session.getAttribute("email");

        if (myOtp==otp) {

            // check user in database
            User user = this.userRepository.getUserByUserName(email);
            if (user==null) {
                // send error message
                session.setAttribute("message", "User does not exist with this email!!");
                System.out.println("register page");
                return "register";
            }else {
                model.addAttribute("user",user);
                // send change password form
                System.out.println("send-otp page");
                return "user-profile";
            }
        }else {
            session.setAttribute("message", "You have entered wrong otp !!");
            System.out.println("validate otp");
            return "validate-otp";
        }
    }

}
