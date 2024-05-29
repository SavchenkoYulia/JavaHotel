package com.hotel.hotel.controllers;


import com.hotel.hotel.models.Login;
import com.hotel.hotel.repost.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
@Autowired
    private LoginRepository loginRepository;
@GetMapping("/login")
    public String login(Model model){
    model.addAttribute("login","Увійти");
    return "login";
}
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("loginForm") Login login) {
        loginRepository.save(login);
        return "redirect:/logs";
    }
@GetMapping("/logs")
    public String logs(){
    return "logs";
}
}
