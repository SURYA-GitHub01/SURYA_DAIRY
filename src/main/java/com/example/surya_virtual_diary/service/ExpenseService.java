package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Expense;
import com.example.surya_virtual_diary.repository.ExpenseRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }
}
