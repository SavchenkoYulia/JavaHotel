package com.hotel.hotel.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller//обовязково вказати щоб систкма зрозуміла що це контролер
public class ImageController {
    @GetMapping("/images/{imageName}")//анотація вказує на який uri буде підключатися функція яка буде підключатися нижче
    @ResponseBody//обовязкова анотація для того щоб метод реагувала на src браузера
    public byte[] getImage(@PathVariable String imageName) throws IOException{//throws переадресовує помилку вверх по черзі
        //обовязково зображення зберігається в папці resources бо якщо так в бібліотеці io вже є клас resources
        Resource resource = new ClassPathResource("images/" + imageName);// обєкт resource створюємо на основі класу resource
        return Files.readAllBytes(Paths.get(resource.getURI()));//readAllBytes зчитує картинку в дужках шлях
    }


}
