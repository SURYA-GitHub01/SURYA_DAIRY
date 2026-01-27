package com.example.surya_virtual_diary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoansController {

    @GetMapping("/loans")
    public String loans(Model model) {
        model.addAttribute("view", "loans");
        return "layout";
    }
}
