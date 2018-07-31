package com.example.mohamed.mazadateee.models;

public class product {

    private String id;
    private String name;
    private String description;
    private String image;
    private String price;


    public product(String id, String name, String description, String image, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
