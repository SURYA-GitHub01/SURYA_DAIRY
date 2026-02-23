package com.example.surya_virtual_diary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String companyName;

    @Transient
    private boolean shouldHighlightCompanyName;

    public Project(String name, LocalDate startDate, LocalDate endDate, String companyName) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
        this.shouldHighlightCompanyName = false;
    }

    public String getFormattedStartDate() {
        if (startDate == null) {
            return "N/A";
        }
        return startDate.format(DateTimeFormatter.ofPattern("dd, MMMM, yyyy"));
    }

    public String getFormattedEndDate() {
        if (endDate == null || endDate.isAfter(LocalDate.now())) {
            return "Current";
        }
        return endDate.format(DateTimeFormatter.ofPattern("dd, MMMM, yyyy"));
    }

    public boolean isCurrent() {
        return endDate == null || endDate.isAfter(LocalDate.now());
    }

    public boolean isEndDateCurrentDay() {
        return endDate != null && endDate.isEqual(LocalDate.now());
    }
}
