package com.example.surya_virtual_diary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreciousMetalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // "Gold" or "Silver"
    private double weight; // in grams
    private double price; // total price paid
    private String purchaseDate; // purchase date
    private String purity; // e.g., "24K", "22K", "999"

    public PreciousMetalEntry(String type, double weight, double price, String purchaseDate, String purity) {
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.purity = purity;
    }

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
