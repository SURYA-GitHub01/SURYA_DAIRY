package com.example.surya_virtual_diary.models;

import java.text.NumberFormat;
import java.util.Locale; // Import Locale

public class SalaryEntry {
    private String companyName;
    private double totalSalary;
    private String month; // Using String for month for simplicity, can be Month enum or int
    private int year;
    private boolean shouldHighlightYear; // New field for year coloring
    private boolean isAmountIncreased;
    private boolean isJanuary;   // New field for amount increase coloring

    public SalaryEntry(String companyName, double totalSalary, String month, int year) {
        this.companyName = companyName;
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
        this.shouldHighlightYear = false;
        this.isAmountIncreased = false;
        this.isJanuary = false; // Initialize new field
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

    public boolean isShouldHighlightYear() {
        return shouldHighlightYear;
    }

    public void setShouldHighlightYear(boolean shouldHighlightYear) {
        this.shouldHighlightYear = shouldHighlightYear;
    }

    public boolean isAmountIncreased() {
        return isAmountIncreased;
    }

    public void setAmountIncreased(boolean amountIncreased) {
        isAmountIncreased = amountIncreased;
    }

    public boolean isJanuary() {
        return isJanuary;
    }

    public void setJanuary(boolean january) {
        isJanuary = january;
    }

    // New method to get formatted salary with Indian Rupee symbol and space
    public String getFormattedTotalSalary() {
        Locale indianLocale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indianLocale);

        if (this.totalSalary == (long) this.totalSalary) {
            // If it's a whole number, set no decimal places
            currencyFormatter.setMinimumFractionDigits(0);
            currencyFormatter.setMaximumFractionDigits(0);
        } else {
            // Otherwise, allow standard currency decimal places (usually 2)
            currencyFormatter.setMinimumFractionDigits(2); // Ensure at least two for non-whole numbers
            currencyFormatter.setMaximumFractionDigits(2); // Limit to two for consistency
        }

        String formatted = currencyFormatter.format(this.totalSalary);

        // Ensure there's a space after the currency symbol if not already present
        if (!formatted.contains("₹ ")) {
            formatted = formatted.replace("₹", "₹ ");
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
