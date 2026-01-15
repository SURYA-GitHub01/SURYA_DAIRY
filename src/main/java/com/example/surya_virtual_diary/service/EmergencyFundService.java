package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.EmergencyFund;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyFundService {

    private static final List<EmergencyFund> emergencyFunds = new ArrayList<>();

        private static long emergencyFundIdCounter = 0;
    
    static {
        emergencyFunds.add(new EmergencyFund(++emergencyFundIdCounter, "Saving Account", 1000.0, LocalDate.of(2026, 1, 1)));
    }

    public List<EmergencyFund> getEmergencyFunds() {
        return emergencyFunds;
    }
}
