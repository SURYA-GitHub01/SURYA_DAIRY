package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.SalaryEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaryService {

    private static final List<SalaryEntry> salaryEntries = new ArrayList<>();

    static {
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "September", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "October", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "November", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "December", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "January", 2026));
    }

    public List<SalaryEntry> getSalaryEntries() {
        return salaryEntries;
    }

    public Optional<SalaryEntry> getLastMonthSalaryEntry() {
        return salaryEntries.stream()
                .max(Comparator
                        .comparing(SalaryEntry::getYear)
                        .thenComparing(entry -> getMonthValue(entry.getMonth())));
    }

    public double getLastMonthSalaryAmount() {
        return getLastMonthSalaryEntry()
                .map(SalaryEntry::getTotalSalary)
                .orElse(0.0); // Return 0.0 if no salary entries found
    }

    // Helper method to convert month name to an integer for sorting
    private int getMonthValue(String month) {
        return switch (month) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            case "June" -> 6;
            case "July" -> 7;
            case "August" -> 8;
            case "September" -> 9;
            case "October" -> 10;
            case "November" -> 11;
            case "December" -> 12;
            default -> 0; // Should not happen with valid month names
        };
    }
}