package com.example.surya_virtual_diary.models;

import java.text.NumberFormat;
import java.util.Locale; // Import Locale

public class SalaryEntry {
    private String companyName;
    private double totalSalary;
    private String month; // Using String for month for simplicity, can be Month enum or int
    private int year;

    public SalaryEntry(String companyName, double totalSalary, String month, int year) {
        this.companyName = companyName;
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
    }

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // New method to get formatted salary with Indian Rupee symbol and space
    public String getFormattedTotalSalary() {
        Locale indianLocale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indianLocale);
        // Format and explicitly add a space if not already present
        String formatted = currencyFormatter.format(this.totalSalary);
        if (!formatted.contains("₹ ")) {
            return formatted.replace("₹", "₹ ");
        }
        return formatted;
    }

    // Setters (optional, but good practice)
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
