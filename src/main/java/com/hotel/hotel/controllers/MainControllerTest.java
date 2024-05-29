package com.hotel.hotel.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//анотація вебмвс тест потрібно для тестування веб контролера вона завантажує лиш контекст
@WebMvcTest(MainController.class)

public class MainControllerTest {
    //мокмвс - обєкт використовується для виконання http запитів та перевірки відповідей
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp(){}
    @Test
    public void testIndex()throws Exception{


        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }
    @Test
    public void testAbout()throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}

