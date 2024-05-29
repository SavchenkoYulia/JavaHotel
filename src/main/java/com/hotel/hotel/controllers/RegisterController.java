package com.hotel.hotel.controllers;


import com.hotel.hotel.models.Register;
import com.hotel.hotel.repost.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private RegisterRepository registerRepository;
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("register", "Зареєструватися");
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("register")Register register){
        registerRepository.save(register);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

}
