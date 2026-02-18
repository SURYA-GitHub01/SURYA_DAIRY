package com.example.surya_virtual_diary.models;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RecurringDepositEntry {
    private String name; // e.g., "Post Office RD"
    private double monthlyAmount;
    private LocalDate startDate;
    private int tenureMonths;
    private double interestRate;
    private String status;

    public RecurringDepositEntry(String name, double monthlyAmount, String startDate, int tenureMonths, double interestRate, String status) {
        this.name = name;
        this.monthlyAmount = monthlyAmount;
        this.startDate = LocalDate.parse(startDate); // Expecting YYYY-MM-DD
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
        this.status = status;
    }

    // Getters
    public String getName() { return name; }
    public double getMonthlyAmount() { return monthlyAmount; }
    public LocalDate getStartDate() { return startDate; }
    public int getTenureMonths() { return tenureMonths; }
    public double getInterestRate() { return interestRate; }
    public String getStatus() { return status; }

    // Calculations
    public long getMonthsPaidTillNow() {
        if (status.equalsIgnoreCase("Completed")) {
            return tenureMonths;
        }
        LocalDate now = LocalDate.now();
        if (now.isBefore(startDate)) return 0;
        
        Period period = Period.between(startDate.withDayOfMonth(1), now.withDayOfMonth(1));
        long months = period.getYears() * 12L + period.getMonths() + 1; // +1 to include current month
        return Math.min(months, tenureMonths);
    }

    public double getTotalPaidTillNow() {
        return getMonthsPaidTillNow() * monthlyAmount;
    }

    public int getMaturityYear() {
        return startDate.plusMonths(tenureMonths).getYear();
    }

    public double getTotalTenureYears() {
        return tenureMonths / 12.0;
    }

    public String getFormattedMonthlyAmount() {
        return formatCurrency(this.monthlyAmount);
    }

    public String getFormattedTotalPaidTillNow() {
        return formatCurrency(getTotalPaidTillNow());
    }

    public String getFormattedTotalPrincipal() {
        return formatCurrency(monthlyAmount * tenureMonths);
    }

    public String getFormattedStartDate() {
        return startDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public String getFormattedMaturityDate() {
        return startDate.plusMonths(tenureMonths).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    private String formatCurrency(double amount) {
        Locale indianLocale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indianLocale);
        String formatted = currencyFormatter.format(amount);
        if (!formatted.contains("₹ ")) {
            formatted = formatted.replace("₹", "₹ ");
        }
        return formatted;
    }
}
