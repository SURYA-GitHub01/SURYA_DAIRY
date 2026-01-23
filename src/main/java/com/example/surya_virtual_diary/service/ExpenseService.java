package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Expense;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private static final List<Expense> expenses = new ArrayList<>();
    private static long expenseIdCounter = 0;

    static {
        expenses.add(new Expense(++expenseIdCounter, "Major Expense 1", 1000.0, LocalDate.now().minusDays(10)));
        expenses.add(new Expense(++expenseIdCounter, "Major Expense 2", 2500.0, LocalDate.now().minusDays(5)));
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
