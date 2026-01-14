package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.EmergencyFund;
import com.example.surya_virtual_diary.models.Savings;
import com.example.surya_virtual_diary.service.EmergencyFundService;
import com.example.surya_virtual_diary.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SavingsOverviewController {

    private final SavingsService savingsService;
    private final EmergencyFundService emergencyFundService;

    @Autowired
    public SavingsOverviewController(SavingsService savingsService, EmergencyFundService emergencyFundService) {
        this.savingsService = savingsService;
        this.emergencyFundService = emergencyFundService;
    }

    @GetMapping("/savings-overview")
    public String savingsOverview(Model model) {
        List<Savings> savingsList = savingsService.getSavings();
        List<EmergencyFund> emergencyFundList = emergencyFundService.getEmergencyFunds();

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