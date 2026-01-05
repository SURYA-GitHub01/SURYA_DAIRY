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
        projectList.add(new Project("RDPS (EduHK)", LocalDate.of(2025, 10, 01), LocalDate.of(2025, 12, 31), "aTalent"));
        // A past project
        projectList.add(new Project("DHL", LocalDate.of(2026, 1, 01), null, "aTalent"));


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
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "November", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "December", 2025));


        // Sort by company name and then by year/month for consistent grouping
        salaryEntries.sort(Comparator
                .comparing(SalaryEntry::getCompanyName)
                .thenComparingInt(SalaryEntry::getYear)
                .thenComparing(SalaryEntry::getMonth)); // Assuming alphabetical month is sufficient for this sample

        Map<String, List<SalaryEntry>> groupedSalaries = salaryEntries.stream()
                .collect(Collectors.groupingBy(SalaryEntry::getCompanyName));

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
