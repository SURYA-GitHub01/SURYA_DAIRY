package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.service.RDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.NumberFormat;
import java.util.Locale;

@Controller
public class RDController {

    private final RDService rdService;

    @Autowired
    public RDController(RDService rdService) {
        this.rdService = rdService;
    }

    @GetMapping("/rd")
    public String recurringDeposit(Model model) {
        model.addAttribute("rdEntries", rdService.getRdEntries());
        model.addAttribute("totalMonthlyInvestment", formatCurrency(rdService.getTotalMonthlyInvestment()));
        model.addAttribute("totalAccumulatedInvestment", formatCurrency(rdService.getTotalAccumulatedInvestment()));
        model.addAttribute("view", "rd");
        return "layout";
    }

    private String formatCurrency(double amount) {
        Locale indianLocale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indianLocale);
        String formatted = currencyFormatter.format(amount);
        if (!formatted.contains("₹ ")) {
            formatted = formatted.replace("₹", "₹ ");
        }
        return formatted;
    }
}
