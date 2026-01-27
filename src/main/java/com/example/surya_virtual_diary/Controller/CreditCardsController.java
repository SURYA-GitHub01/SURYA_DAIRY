package com.example.surya_virtual_diary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreditCardsController {

    @GetMapping("/credit-cards")
    public String creditCards(Model model) {
        model.addAttribute("view", "credit-cards");
        return "layout";
    }
}
