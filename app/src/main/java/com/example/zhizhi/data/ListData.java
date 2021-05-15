package com.example.zhizhi.data;

public class ListData {
    private String name;
    private String theme;
    private String day;
    private String address;
    private String main_theme;
    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public String getDay() {
        return day;
    }

    public String getAddress() {
        return address;
    }

    public String getMain_theme() {
        return main_theme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMain_theme(String main_theme) {
        this.main_theme = main_theme;
    }

    public ListData(String name, String theme, String day, String address) {
        this.name = name;
        this.theme = theme;
        this.day = day;
        this.address = address;
    }

    public ListData(String name, String theme, String day) {
        this.name = name;
        this.theme = theme;
        this.day = day;
    }

}
