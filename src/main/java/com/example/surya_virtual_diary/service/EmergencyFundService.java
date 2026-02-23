package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.EmergencyFund;
import com.example.surya_virtual_diary.repository.EmergencyFundRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergencyFundService {

    private final EmergencyFundRepository emergencyFundRepository;

    public List<EmergencyFund> getEmergencyFunds() {
        return emergencyFundRepository.findAll();
    }
}
