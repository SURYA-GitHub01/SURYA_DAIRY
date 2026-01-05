package com.example.surya_virtual_diary.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // Import DateTimeFormatter

public class Project {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String companyName;

    public Project(String name, LocalDate startDate, LocalDate endDate, String companyName) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // New method to get formatted start date (day, month, year)
    public String getFormattedStartDate() {
        if (startDate == null) {
            return "N/A";
        }
        return startDate.format(DateTimeFormatter.ofPattern("dd, MMMM, yyyy"));
    }

    // New method to get formatted end date (day, month, year) or "Current"
    public String getFormattedEndDate() {
        if (endDate == null || endDate.isAfter(LocalDate.now())) {
            return "Current";
        }
        return endDate.format(DateTimeFormatter.ofPattern("dd, MMMM, yyyy"));
    }

    // New method to check if the project is current
    public boolean isCurrent() {
        return endDate == null || endDate.isAfter(LocalDate.now());
    }
}
