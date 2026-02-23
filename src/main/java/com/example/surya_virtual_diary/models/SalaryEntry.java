package com.example.surya_virtual_diary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private double totalSalary;
    private String month;
    private int year;

    @Transient
    private boolean shouldHighlightYear;
    @Transient
    private boolean isAmountIncreased;
    @Transient
    private boolean isJanuary;

    public SalaryEntry(String companyName, double totalSalary, String month, int year) {
        this.companyName = companyName;
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
        this.shouldHighlightYear = false;
        this.isAmountIncreased = false;
        this.isJanuary = false;
    }

    public String getFormattedTotalSalary() {
        Locale indianLocale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indianLocale);

        if (this.totalSalary == (long) this.totalSalary) {
            currencyFormatter.setMinimumFractionDigits(0);
            currencyFormatter.setMaximumFractionDigits(0);
        } else {
            currencyFormatter.setMinimumFractionDigits(2);
            currencyFormatter.setMaximumFractionDigits(2);
        }

        String formatted = currencyFormatter.format(this.totalSalary);

        if (!formatted.contains("₹ ")) {
            formatted = formatted.replace("₹", "₹ ");
        }
        return formatted;
    }
}
