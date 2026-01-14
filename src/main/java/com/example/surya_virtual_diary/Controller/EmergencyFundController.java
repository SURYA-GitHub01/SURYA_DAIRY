package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.EmergencyFund;
import com.example.surya_virtual_diary.service.EmergencyFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmergencyFundController {

    private final EmergencyFundService emergencyFundService;

    @Autowired
    public EmergencyFundController(EmergencyFundService emergencyFundService) {
        this.emergencyFundService = emergencyFundService;
    }

    @GetMapping("/emergency-fund")
    public String emergencyFund(Model model) {
        List<EmergencyFund> emergencyFundList = emergencyFundService.getEmergencyFunds();
        double totalEmergencyFund = emergencyFundList.stream().mapToDouble(EmergencyFund::getAmount).sum();
        model.addAttribute("emergencyFundList", emergencyFundList);
        model.addAttribute("totalEmergencyFund", totalEmergencyFund);
        model.addAttribute("view", "emergency-fund");
        return "layout";
    }
}
