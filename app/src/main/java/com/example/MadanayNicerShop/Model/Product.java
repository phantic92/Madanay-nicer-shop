package com.example.MadanayNicerShop.Model;

public class Product {
    private String mTitle;
    private String mDescription;
    private String mPrice;
    private String mQuantity;
    private int mImage;
    private String mSubtotal;

    public Product(String title, String description, String price, String quantity, String subtotal,
                   int image) {
        this.mTitle = title;
        this.mDescription = description;
        this.mPrice = price;
        this.mQuantity = quantity;
        this.mSubtotal = subtotal;
        this.mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }
    public String getDescription() {
        return mDescription;
    }
    public String getPrice() {
        return mPrice;
    }
    public String getQuantity() {
        return mQuantity;
    }
    public String getSubtotal() {
        return mSubtotal;
    }
    public int getImage() {
        return mImage;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
    public void setDescription(String description) {
        this.mDescription = description;
    }
    public void setPrice(String price) {
        this.mPrice = price;
    }
    public void setQuantity(String quantity) {
        this.mQuantity = quantity;
    }
    public void setSubtotal(String subtotal) {
        this.mSubtotal = subtotal;
    }
    public void setImage(int image) {
        this.mImage = image;
    }
}
