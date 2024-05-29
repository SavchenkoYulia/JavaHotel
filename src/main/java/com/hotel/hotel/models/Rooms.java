package com.hotel.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullContent, title, img_room;
    private double price;
    private int kolvo, status_room;

    // Конструктори
    public Rooms() {}

    public Rooms(String fullContent, String title, double price, int kolvo, int status_room, String img_room) {
        this.fullContent = fullContent;
        this.title = title;
        this.price = price;
        this.kolvo = kolvo;
        this.status_room = status_room;
        this.img_room = img_room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public int getStatus_room() {
        return status_room;
    }

    public void setStatus_room(int status_room) {
        this.status_room = status_room;
    }
    public String getImg_room(){
        return img_room;
    }

    public void setImg_room(String img_room){
        this.img_room = img_room;
    }
}

