package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Savings;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SavingsService {

    private static final List<Savings> savings = new ArrayList<>();

        private static long savingsIdCounter = 0;

    static {
        savings.add(new Savings(++savingsIdCounter, "Backup Amount", 10000.0, LocalDate.of(2026, 1, 1)));

    }

    public List<Savings> getSavings() {
        return savings;
    }
}
