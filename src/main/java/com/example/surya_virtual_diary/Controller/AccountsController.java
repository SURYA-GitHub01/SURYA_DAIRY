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
public class AccountsController {

    private final SavingsService savingsService;
    private final EmergencyFundService emergencyFundService;

    @Autowired
    public AccountsController(SavingsService savingsService, EmergencyFundService emergencyFundService) {
        this.savingsService = savingsService;
        this.emergencyFundService = emergencyFundService;
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        List<Savings> savingsList = savingsService.getSavings();
        double totalSavings = savingsList.stream().mapToDouble(Savings::getAmount).sum();
        model.addAttribute("savingsList", savingsList);
        model.addAttribute("totalSavings", totalSavings);

        List<EmergencyFund> emergencyFundList = emergencyFundService.getEmergencyFunds();
        double totalEmergencyFund = emergencyFundList.stream().mapToDouble(EmergencyFund::getAmount).sum();
        model.addAttribute("emergencyFundList", emergencyFundList);
        model.addAttribute("totalEmergencyFund", totalEmergencyFund);

        double grandTotal = totalSavings + totalEmergencyFund;
        model.addAttribute("grandTotal", grandTotal);

        model.addAttribute("view", "accounts");
        return "layout";
    }
}
