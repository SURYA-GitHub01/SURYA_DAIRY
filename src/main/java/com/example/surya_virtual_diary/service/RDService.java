package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.RecurringDepositEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RDService {

    private static final List<RecurringDepositEntry> rdEntries = new ArrayList<>();

    static {
        // Sample data
        rdEntries.add(new RecurringDepositEntry("Post Office RD", 5000.0, "2023-01-01", 60, 6.7, "Active"));
        rdEntries.add(new RecurringDepositEntry("SBI Bank RD", 2000.0, "2024-06-01", 24, 6.5, "Active"));
        rdEntries.add(new RecurringDepositEntry("HDFC Savings RD", 10000.0, "2022-01-01", 36, 7.0, "Completed"));
    }

    public List<RecurringDepositEntry> getRdEntries() {
        return rdEntries;
    }

    public double getTotalMonthlyInvestment() {
        return rdEntries.stream()
                .filter(e -> "Active".equalsIgnoreCase(e.getStatus()))
                .mapToDouble(RecurringDepositEntry::getMonthlyAmount)
                .sum();
    }

    public double getTotalAccumulatedInvestment() {
        return rdEntries.stream()
                .mapToDouble(RecurringDepositEntry::getTotalPaidTillNow)
                .sum();
    }
}
