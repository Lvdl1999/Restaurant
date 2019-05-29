package com.example.restaurant;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private String menu_description, menu_name, sort_menu, url;
    private Double price;

    // saving all variables
    MenuItem(String menu_name, String menu_description, String url, Double price, String sort_menu) {
        this.url = url;
        this.menu_name = menu_name;
        this.price = price;
        this.menu_description = menu_description;
        this.sort_menu = sort_menu;
    }

    // getters and setters
    public String getMenu_description() {
        return menu_description;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public String getImageUrl() {
        return url;
    }

    public Double getPrice() {
        return price;
    }
}
