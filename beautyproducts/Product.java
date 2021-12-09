package com.example.beautyproducts;

public class Product {
    //Class that handles the getters and setters
    private String name;
    private double price;
    private String descrip;
    private int image;

    //Methods that sets and gets values of the product details to the repository class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
