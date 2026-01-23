package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Expense;
import com.example.surya_virtual_diary.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expense")
    public String expense(Model model) {
        List<Expense> expenses = expenseService.getExpenses();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalExpenses", totalExpenses);
        model.addAttribute("view", "expense");
        return "layout";
    }
}
