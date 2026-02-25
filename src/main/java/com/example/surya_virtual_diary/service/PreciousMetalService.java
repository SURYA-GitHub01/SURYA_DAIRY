package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.PreciousMetalEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreciousMetalService {

    private static final List<PreciousMetalEntry> entries = new ArrayList<>();

    static {
        // Sample data
        entries.add(new PreciousMetalEntry("Gold", 5.0, 35000.0, "2024-05-10"));
        entries.add(new PreciousMetalEntry("Gold", 2.0, 14500.0, "2024-08-15"));
        entries.add(new PreciousMetalEntry("Silver", 100.0, 8500.0, "2024-06-20"));
        entries.add(new PreciousMetalEntry("Silver", 50.0, 4200.0, "2024-09-05"));
    }

    public List<PreciousMetalEntry> getGoldEntries() {
        return entries.stream()
                .filter(e -> "Gold".equalsIgnoreCase(e.getType()))
                .collect(Collectors.toList());
    }

    public List<PreciousMetalEntry> getSilverEntries() {
        return entries.stream()
                .filter(e -> "Silver".equalsIgnoreCase(e.getType()))
                .collect(Collectors.toList());
    }

    public double getTotalGoldWeight() {
        return getGoldEntries().stream().mapToDouble(PreciousMetalEntry::getWeight).sum();
    }

    public double getTotalSilverWeight() {
        return getSilverEntries().stream().mapToDouble(PreciousMetalEntry::getWeight).sum();
    }

    public double getTotalGoldValue() {
        return getGoldEntries().stream().mapToDouble(PreciousMetalEntry::getPrice).sum();
    }

    public double getTotalSilverValue() {
        return getSilverEntries().stream().mapToDouble(PreciousMetalEntry::getPrice).sum();
    }

    public double getTotalValue() {
        return getTotalGoldValue() + getTotalSilverValue();
    }
}
