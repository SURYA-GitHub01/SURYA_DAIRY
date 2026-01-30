package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.SalaryEntry;
import com.example.surya_virtual_diary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/salary")
    public String salary(Model model) {
        List<SalaryEntry> salaryEntries = salaryService.getSalaryEntries();
        
        // Correct chronological month sorting
        Map<String, Integer> monthOrder = Map.ofEntries(
                Map.entry("January", 1), Map.entry("February", 2), Map.entry("March", 3),
                Map.entry("April", 4), Map.entry("May", 5), Map.entry("June", 6),
                Map.entry("July", 7), Map.entry("August", 8), Map.entry("September", 9),
                Map.entry("October", 10), Map.entry("November", 11), Map.entry("December", 12)
        );

        salaryEntries.sort(Comparator
                .comparing(SalaryEntry::getCompanyName)
                .thenComparingInt(SalaryEntry::getYear)
                .thenComparing(entry -> monthOrder.get(entry.getMonth())));

        // Logic for Year Highlighting (Part 1)
        int previousYear = -1; // Sentinel value, assuming years are non-negative
        for (SalaryEntry entry : salaryEntries) {
            if (entry.getYear() != previousYear) {
                entry.setShouldHighlightYear(true);
                previousYear = entry.getYear();
            }
            // Logic for January Highlighting
            if ("January".equals(entry.getMonth())) {
                entry.setJanuary(true);
            }
        }

        Map<String, List<SalaryEntry>> groupedSalaries = salaryEntries.stream()
                .collect(Collectors.groupingBy(SalaryEntry::getCompanyName));

        // Logic for Amount Increase (Part 2)
        groupedSalaries.forEach((company, entries) -> {
            double previousTotalSalary = -1.0; // Sentinel value, assuming salaries are non-negative
            for (SalaryEntry entry : entries) {
                if (entry.getTotalSalary() > previousTotalSalary) {
                    entry.setAmountIncreased(true);
                }
                previousTotalSalary = entry.getTotalSalary();
            }
        });

        model.addAttribute("groupedSalaries", groupedSalaries);
        model.addAttribute("view", "salary");
        return "layout";
    }
}
