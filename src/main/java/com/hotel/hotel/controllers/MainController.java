package com.hotel.hotel.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//деректива,вказує що це контролер
public class MainController {
    @GetMapping("/") //@RequestParam(name="name", required=false, defaultValue="World") String name
    public String index(Model model) {
        model.addAttribute("title", "головна сторінка готелю");
       // model.addAttribute("developer","Savchenko Yulia");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","Сторінка про нас");
        return "about";
    }
    /*@GetMapping("/number")
    public String number(Model model){
        model.addAttribute("title","Номери");
        return  "number";
    }

     */

}










