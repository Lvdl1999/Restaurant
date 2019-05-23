package com.example.restaurant;

public class MenuItem {

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

    public void setMenu_description(String menu_description) {
        this.menu_description = menu_description;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getSort_menu() {
        return sort_menu;
    }

    public void setSort_menu(String sort_menu) {
        this.sort_menu = sort_menu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
