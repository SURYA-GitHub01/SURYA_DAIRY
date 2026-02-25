package com.example.surya_virtual_diary.models;

import java.text.NumberFormat;
import java.util.Locale;

public class PreciousMetalEntry {
    private String type; // "Gold" or "Silver"
    private double weight; // in grams
    private double price; // total price paid
    private String date; // purchase date

    public PreciousMetalEntry(String type, double weight, double price, String date) {
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.date = date;
    }

    // Getters
    public String getType() { return type; }
    public double getWeight() { return weight; }
    public double getPrice() { return price; }
    public String getDate() { return date; }

    // Setters
    public void setType(String type) { this.type = type; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setPrice(double price) { this.price = price; }
    public void setDate(String date) { this.date = date; }

    public String getFormattedPrice() {
        Locale indianLocale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indianLocale);
        String formatted = currencyFormatter.format(this.price);
        if (!formatted.contains("₹ ")) {
            formatted = formatted.replace("₹", "₹ ");
        }
        return formatted;
    }
}
