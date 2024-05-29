package com.hotel.hotel.controllers;

import org.springframework.ui.Model;
import com.hotel.hotel.models.Rooms;
import com.hotel.hotel.repost.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CatalogController {
    @Autowired
    private RoomsRepository roomsRepository;

    @GetMapping("/number")
    public String number(Model model) {
        Iterable<Rooms> rooms = roomsRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "number";
    }

    @GetMapping("/number/add")
    public String numberAdd(Model model) {
        model.addAttribute("title", "Додати номер");
        return "numberAdd";
    }

    //УВАГА ДЛЯ ТОГО ЩОБ ЦІ МЕТОДИ ПРАЦЮВАЛИ В КЛАСІ МОДЕЛЬ ТРЕБА СТВОРИТИ ДВА КОНСТРУКТОРИ З ПАРАМЕТРАМИ ТА БЕЗ
    @PostMapping("/number/add")//пишемо анотацію яка працює з постом
    public String numberPostAdd(@ModelAttribute("rooms") Rooms rooms) {//створюємо метод який отримує набір атрибутів нашої форми і передає модель обєкт
        roomsRepository.save(rooms);//на основі інтерфейсу репозиторію який записує в бд отримані параметри
        return "redirect:/number";//робимо перенаправлення на каталог
    }

    //інший спосіб "традиційний"
/*
    @PostMapping("/number/add") // пишемо анотацію яка працює з постом
    public String numberPostAdd2(@RequestParam String title, @RequestParam String price, @RequestParam String kolvo, @RequestParam String full_content, Model model){// @RequestParam отримуємо дані форми у вигляді рядкових даних
        Rooms rooms = new Rooms(full_content,title,Double.parseDouble(price) ,Integer.parseInt(kolvo));//створює обєкт моделі та в конструктор передаємо отримані параметри, УВАГА дані треба преобразовувати під тип даних в таблиці в бд
        roomsRepository.save(rooms);//на основі інтерфейсу репозиторію який записує в бд отримані параметри
        return "redirect:/number";//робимо перенаправлення на каталог
    }
    */

    @GetMapping("/number/{id}")
    public String numberDetalShow(@PathVariable(value = "id") long id, Model model) {
        Optional<Rooms> room = roomsRepository.findById(id);
        ArrayList<Rooms> result = new ArrayList<>();
        room.ifPresent(result::add);
        model.addAttribute("room", result);
        return "view_number";

    }

    @GetMapping("/number/{id}/edit")
    public String numberEdit(@PathVariable(value = "id") long id, Model model) {
        if (!roomsRepository.existsById(id)) {
            return "redirect:/number";
        }
        Optional<Rooms> room = roomsRepository.findById(id);
        ArrayList<Rooms> result = new ArrayList<>();
        room.ifPresent(result::add);
        model.addAttribute("room", result);
        return "edit_room";

    }

    @PostMapping("/number/{id}/edit")
    public String roomPostEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String price, @RequestParam String kolvo, @RequestParam String fullContent, @RequestParam String status_room, Model model) {
        Rooms rooms = roomsRepository.findById(id).orElseThrow(); //робимо пошук запису по шд, якщо метод findById(id) верне фолс то спрацює значення тру яке предасть значенння іншому меотоду
        rooms.setTitle(title);// через методи міняємо дані
        rooms.setPrice(Float.parseFloat(price));
        rooms.setKolvo(Integer.parseInt(kolvo));
        rooms.setFullContent(fullContent);
        rooms.setStatus_room(Integer.parseInt(status_room));
        roomsRepository.save(rooms);    //зберігаємо по ід знайдені обєкти
        return "redirect:/number";
    }

    @PostMapping("/number/{id}/delete")
    public String roomPostDelete(@PathVariable(value = "id") long id, Model model) {
        Rooms rooms = roomsRepository.findById(id).orElseThrow();
        roomsRepository.delete(rooms);
        return "redirect:/number";
    }

    @GetMapping("/catalog/search")
    public String searchByName(@RequestParam("search") String search, Model model) {
        Iterable<Rooms> rooms = roomsRepository.findByTitleContainingIgnoreCase(search);
        model.addAttribute("rooms", rooms);
        return "number";
    }



    @PostMapping("/number/{id}/reserve")
    public String roomPostEditStatus(@PathVariable(value = "id") long id, Model model) {
        Rooms rooms = roomsRepository.findById(id).orElseThrow();
        rooms.setStatus_room(1);
        roomsRepository.save(rooms);

        return "redirect:/number";
    }
}
