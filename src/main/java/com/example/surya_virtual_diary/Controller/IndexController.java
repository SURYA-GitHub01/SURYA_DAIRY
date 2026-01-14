package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Project;
import com.example.surya_virtual_diary.models.SalaryEntry;
import com.example.surya_virtual_diary.models.Savings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        // --- Data Duplication ---
        // Projects
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Virtual Diary", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), "Personal"));
        projects.add(new Project("E-commerce Website", LocalDate.of(2023, 5, 15), LocalDate.of(2023, 11, 20), "Client A"));
        projects.add(new Project("Mobile App for Fitness", LocalDate.of(2025, 1, 10), null, "Client B"));
        projects.add(new Project("AI Chatbot", LocalDate.of(2024, 3, 1), null, "Client C"));

        // Salary
        List<SalaryEntry> salaryEntries = new ArrayList<>();
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "September", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "October", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "November", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "December", 2025));


        // Savings
        List<Savings> savingsList = new ArrayList<>();
        savingsList.add(new Savings(1L, "Initial deposit", 1000.0, LocalDate.of(2024, 1, 15)));
        savingsList.add(new Savings(2L, "Monthly savings", 250.0, LocalDate.of(2024, 2, 1)));
        savingsList.add(new Savings(3L, "Bonus", 500.0, LocalDate.of(2024, 2, 20)));

        // --- Calculations for stats ---
        long totalProjects = projects.size();
        double totalSalary = salaryEntries.stream().mapToDouble(SalaryEntry::getTotalSalary).sum();
        double totalSavings = savingsList.stream().mapToDouble(Savings::getAmount).sum();
        String currentCompany = salaryEntries.stream()
                .max(Comparator.comparing(SalaryEntry::getYear).thenComparing(SalaryEntry::getMonth))
                .map(SalaryEntry::getCompanyName)
                .orElse("N/A");


        model.addAttribute("view", "index");
        model.addAttribute("totalProjects", totalProjects);
        model.addAttribute("totalSalary", totalSalary);
        model.addAttribute("totalSavings", totalSavings);
        model.addAttribute("currentCompany", currentCompany);

        return "layout";
    }
}
