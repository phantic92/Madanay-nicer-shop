package com.example.MadanayNicerShop.Model;

public class Product {
    private String title;
    private String description;
    private String price;
    private String quantity;
    private int image;
    private String subtotal;

    public Product(String title, String description, String price, String quantity, String subtotal,
                   int image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() {
        return price;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getSubtotal() {
        return subtotal;
    }
    public int getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
