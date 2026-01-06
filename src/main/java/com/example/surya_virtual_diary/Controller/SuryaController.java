package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Project;
import com.example.surya_virtual_diary.models.SalaryEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SuryaController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("view", "index");
        return "layout";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projectList = new ArrayList<>();
        // Existing project (past)
        projectList.add(new Project("Green Commune", LocalDate.of(2024, 7, 01),LocalDate.of(2024, 8, 31) , "Iyarkai Tech Lab"));

        projectList.add(new Project("Seamless Community Interaction and Management", LocalDate.of(2024, 10, 01),LocalDate.of(2024, 12, 31) , "Infosys Springboard"));

        projectList.add(new Project("RDPS (Education University of HongKong)", LocalDate.of(2025, 9, 01), LocalDate.of(2025, 12, 31), "aTalent"));
        // A past project
        projectList.add(new Project("DHL", LocalDate.of(2026, 1, 01), null, "aTalent"));

        String previousCompanyName = null;
        for (Project project : projectList) {
            if (previousCompanyName == null || !previousCompanyName.equals(project.getCompanyName())) {
                project.setShouldHighlightCompanyName(true);
            }
            previousCompanyName = project.getCompanyName();
        }

        model.addAttribute("projects", projectList);
        model.addAttribute("totalProjects", projectList.size());
        model.addAttribute("view", "projects");
        return "layout";
    }

    @GetMapping("/salary")
    public String salary(Model model) {
        List<SalaryEntry> salaryEntries = new ArrayList<>();
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "September", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "October", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "November", 2025)); // Increased amount
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "December", 2025)); // Decreased amount
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "January", 2026)); // New year, increased amount
        // Sort by company name and then by year/month for consistent grouping and comparison
        salaryEntries.sort(Comparator
                .comparing(SalaryEntry::getCompanyName)
                .thenComparingInt(SalaryEntry::getYear)
                .thenComparing(SalaryEntry::getMonth)); // Assuming alphabetical month is sufficient for this sample

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

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("view", "about");
        return "layout";
    }
}
