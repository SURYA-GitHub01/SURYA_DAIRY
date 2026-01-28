package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Expense;
import com.example.surya_virtual_diary.models.Project;
import com.example.surya_virtual_diary.models.SalaryEntry;
import com.example.surya_virtual_diary.models.Savings;
import com.example.surya_virtual_diary.service.ExpenseService;
import com.example.surya_virtual_diary.service.ProjectService;
import com.example.surya_virtual_diary.service.SalaryService;
import com.example.surya_virtual_diary.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {

    private final ProjectService projectService;
    private final SalaryService salaryService;
    private final SavingsService savingsService;
    private final ExpenseService expenseService;

    @Autowired
    public IndexController(ProjectService projectService, SalaryService salaryService, SavingsService savingsService, ExpenseService expenseService) {
        this.projectService = projectService;
        this.salaryService = salaryService;
        this.savingsService = savingsService;
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public String index(Model model) {
        // --- Fetch data from the central services ---
        List<Project> projects = projectService.getProjects();
        List<SalaryEntry> salaryEntries = salaryService.getSalaryEntries();
        List<Savings> savingsList = savingsService.getSavings();
        List<Expense> expenses = expenseService.getExpenses();

        // --- Calculations for stats ---
        long totalProjects = projects.size();
        double totalSalary = salaryEntries.stream().mapToDouble(SalaryEntry::getTotalSalary).sum();
        double totalSavings = savingsList.stream().mapToDouble(Savings::getAmount).sum();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
        String currentCompany = salaryEntries.stream()
                .max(Comparator.comparing(SalaryEntry::getYear).thenComparing(SalaryEntry::getMonth))
                .map(SalaryEntry::getCompanyName)
                .orElse("N/A");

        String currentRole = "Backend Developer";

        model.addAttribute("view", "index");
        model.addAttribute("totalProjects", totalProjects);
        model.addAttribute("totalSalary", totalSalary);
        model.addAttribute("totalSavings", totalSavings);
        model.addAttribute("totalExpenses", totalExpenses);
        model.addAttribute("currentCompany", currentCompany);
        model.addAttribute("currentRole", currentRole);
        double lastMonthSalaryAmount = salaryService.getLastMonthSalaryAmount();
        model.addAttribute("lastMonthSalaryAmount", lastMonthSalaryAmount);

        return "layout";
    }
}
