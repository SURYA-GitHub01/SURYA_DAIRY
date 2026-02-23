package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.SalaryEntry;
import com.example.surya_virtual_diary.repository.SalaryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final SalaryRepository salaryRepository;

    public List<SalaryEntry> getSalaryEntries() {
        int currentYear = Year.now().getValue();

        return salaryRepository.findAll().stream().map(entry -> {
            if ("January".equals(entry.getMonth()) && entry.getYear() == currentYear) {
                entry.setJanuary(true);
            } else {
                entry.setJanuary(false);
            }
            entry.setShouldHighlightYear(false);
            return entry;
        }).collect(Collectors.toList());
    }

    public Optional<SalaryEntry> getLastMonthSalaryEntry() {
        return salaryRepository.findAll().stream()
                .max(Comparator
                        .comparing(SalaryEntry::getYear)
                        .thenComparing(entry -> getMonthValue(entry.getMonth())));
    }

    public double getLastMonthSalaryAmount() {
        return getLastMonthSalaryEntry()
                .map(SalaryEntry::getTotalSalary)
                .orElse(0.0);
    }

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
            default -> 0;
        };
    }
}