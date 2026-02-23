package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Savings;
import com.example.surya_virtual_diary.repository.SavingsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingsService {

    private final SavingsRepository savingsRepository;

    public List<Savings> getSavings() {
        return savingsRepository.findAll();
    }
}
