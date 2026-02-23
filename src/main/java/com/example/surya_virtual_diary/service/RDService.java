package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.RecurringDepositEntry;
import com.example.surya_virtual_diary.repository.RDRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RDService {

    private final RDRepository rdRepository;

    public List<RecurringDepositEntry> getRdEntries() {
        return rdRepository.findAll();
    }

    public double getTotalMonthlyInvestment() {
        return getRdEntries().stream()
                .filter(e -> "Active".equalsIgnoreCase(e.getStatus()))
                .mapToDouble(RecurringDepositEntry::getMonthlyAmount)
                .sum();
    }

    public double getTotalAccumulatedInvestment() {
        return getRdEntries().stream()
                .mapToDouble(RecurringDepositEntry::getTotalPaidTillNow)
                .sum();
    }
}
