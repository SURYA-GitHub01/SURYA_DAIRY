package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Savings;
import com.example.surya_virtual_diary.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SavingsController {

    private final SavingsService savingsService;

    @Autowired
    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    @GetMapping("/savings")
    public String savings(Model model) {
        List<Savings> savingsList = savingsService.getSavings();
        double totalSavings = savingsList.stream().mapToDouble(Savings::getAmount).sum();
        model.addAttribute("savingsList", savingsList);
        model.addAttribute("totalSavings", totalSavings);
        model.addAttribute("view", "savings");
        return "layout";
    }
}
