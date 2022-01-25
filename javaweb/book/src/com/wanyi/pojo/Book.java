package com.wanyi.pojo;

import java.math.BigDecimal;

public class Book {
    private int id;
    private String name;
    private String author;
    private double price;
    private int stock;
    private int sales;
    private String imgPath = "static/img/default.jpg";

    public Book(int id, String name, String author, double price, int stock, int sales, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        if (imgPath != null && !"".equals(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        if (imgPath != null && !"".equals(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
