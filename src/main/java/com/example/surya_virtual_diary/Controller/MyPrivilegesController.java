package com.example.surya_virtual_diary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPrivilegesController {

    @GetMapping("/my-privileges")
    public String myPrivileges(Model model) {
        model.addAttribute("view", "my-privileges");
        return "layout";
    }
}
