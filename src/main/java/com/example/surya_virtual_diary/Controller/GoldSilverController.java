package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.service.PreciousMetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.NumberFormat;
import java.util.Locale;

@Controller
public class GoldSilverController {

    private final PreciousMetalService preciousMetalService;

    @Autowired
    public GoldSilverController(PreciousMetalService preciousMetalService) {
        this.preciousMetalService = preciousMetalService;
    }

    @GetMapping("/gold-silver")
    public String goldSilver(Model model) {
        model.addAttribute("goldEntries", preciousMetalService.getGoldEntries());
        model.addAttribute("silverEntries", preciousMetalService.getSilverEntries());
        model.addAttribute("totalGoldWeight", preciousMetalService.getTotalGoldWeight());
        model.addAttribute("totalSilverWeight", preciousMetalService.getTotalSilverWeight());
        model.addAttribute("totalGoldValue", formatCurrency(preciousMetalService.getTotalGoldValue()));
        model.addAttribute("totalSilverValue", formatCurrency(preciousMetalService.getTotalSilverValue()));
        model.addAttribute("totalValue", formatCurrency(preciousMetalService.getTotalValue()));
        model.addAttribute("view", "gold-silver");
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
