package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Expense;
import com.example.surya_virtual_diary.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TransactionController {

    private final ExpenseService expenseService;

    @Autowired
    public TransactionController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/transactions")
    public String transactions(Model model) {
        List<Expense> expenses = expenseService.getExpenses();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalExpenses", totalExpenses);
        model.addAttribute("view", "transactions");
        return "layout";
    }
}
