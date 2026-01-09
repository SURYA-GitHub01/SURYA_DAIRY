package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Savings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SavingsController {

    private static long savingsIdCounter = 0;
    private List<Savings> savingsList = new ArrayList<>();

    public SavingsController() {
        // Add some initial data
        savingsList.add(new Savings(++savingsIdCounter, "Initial deposit", 1000.0, LocalDate.of(2024, 1, 15)));
        savingsList.add(new Savings(++savingsIdCounter, "Monthly savings", 250.0, LocalDate.of(2024, 2, 1)));
        savingsList.add(new Savings(++savingsIdCounter, "Bonus", 500.0, LocalDate.of(2024, 2, 20)));
    }

    @GetMapping("/savings")
    public String savings(Model model) {
        double totalSavings = savingsList.stream().mapToDouble(Savings::getAmount).sum();
        model.addAttribute("savingsList", savingsList);
        model.addAttribute("totalSavings", totalSavings);
        model.addAttribute("view", "savings");
        return "layout";
    }
}
