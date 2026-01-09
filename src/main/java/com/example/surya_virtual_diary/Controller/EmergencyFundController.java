package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.EmergencyFund;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmergencyFundController {

    private static long emergencyFundIdCounter = 0;
    private List<EmergencyFund> emergencyFundList = new ArrayList<>();

    public EmergencyFundController() {
        // Add some initial data
        emergencyFundList.add(new EmergencyFund(++emergencyFundIdCounter, "Initial deposit", 500.0, LocalDate.of(2024, 1, 10)));
        emergencyFundList.add(new EmergencyFund(++emergencyFundIdCounter, "Paycheck allocation", 150.0, LocalDate.of(2024, 2, 5)));
        emergencyFundList.add(new EmergencyFund(++emergencyFundIdCounter, "Side hustle income", 300.0, LocalDate.of(2024, 2, 18)));
    }

    @GetMapping("/emergency-fund")
    public String emergencyFund(Model model) {
        double totalEmergencyFund = emergencyFundList.stream().mapToDouble(EmergencyFund::getAmount).sum();
        model.addAttribute("emergencyFundList", emergencyFundList);
        model.addAttribute("totalEmergencyFund", totalEmergencyFund);
        model.addAttribute("view", "emergency-fund");
        return "layout";
    }
}
