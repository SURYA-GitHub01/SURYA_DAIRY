package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.SalaryEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {

    private static final List<SalaryEntry> salaryEntries = new ArrayList<>();

    static {
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "September", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "October", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "November", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "December", 2025));
        salaryEntries.add(new SalaryEntry("aTalent", 8000, "January", 2026));
    }

    public List<SalaryEntry> getSalaryEntries() {
        return salaryEntries;
    }
}
