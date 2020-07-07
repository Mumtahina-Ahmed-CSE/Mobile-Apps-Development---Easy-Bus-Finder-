package com.example.ahsan.easybusfinder;

public class BusData {

    private String Title,Category, Description;
    private int Thumbnail;

    public BusData(){

    }
    public BusData(String title, String category, String description, int thumbnail){
        Title=title;
        Category=category;
        Description=description;
        Thumbnail=thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
