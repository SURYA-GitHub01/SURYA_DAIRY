package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.EmergencyFund;
import com.example.surya_virtual_diary.models.Savings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SavingsOverviewController {

    private List<Savings> savingsList = new ArrayList<>();
    private List<EmergencyFund> emergencyFundList = new ArrayList<>();

    public SavingsOverviewController() {
        // Savings data
        savingsList.add(new Savings(1L, "Initial deposit", 1000.0, LocalDate.of(2024, 1, 15)));
        savingsList.add(new Savings(2L, "Monthly savings", 250.0, LocalDate.of(2024, 2, 1)));
        savingsList.add(new Savings(3L, "Bonus", 500.0, LocalDate.of(2024, 2, 20)));

        // Emergency fund data
        emergencyFundList.add(new EmergencyFund(1L, "Initial deposit", 500.0, LocalDate.of(2024, 1, 10)));
        emergencyFundList.add(new EmergencyFund(2L, "Paycheck allocation", 150.0, LocalDate.of(2024, 2, 5)));
        emergencyFundList.add(new EmergencyFund(3L, "Side hustle income", 300.0, LocalDate.of(2024, 2, 18)));
    }

    @GetMapping("/savings-overview")
    public String savingsOverview(Model model) {
        double totalSavings = savingsList.stream().mapToDouble(Savings::getAmount).sum();
        double totalEmergencyFund = emergencyFundList.stream().mapToDouble(EmergencyFund::getAmount).sum();
        double grandTotal = totalSavings + totalEmergencyFund;

        model.addAttribute("totalSavings", totalSavings);
        model.addAttribute("totalEmergencyFund", totalEmergencyFund);
        model.addAttribute("grandTotal", grandTotal);



        model.addAttribute("view", "savings-overview");
        return "layout";
    }
}