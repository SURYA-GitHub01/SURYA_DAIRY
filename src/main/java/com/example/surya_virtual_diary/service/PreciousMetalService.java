package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.PreciousMetalEntry;
import com.example.surya_virtual_diary.repository.PreciousMetalRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreciousMetalService {

    private final PreciousMetalRepository preciousMetalRepository;

    public List<PreciousMetalEntry> getGoldEntries() {
        return preciousMetalRepository.findByTypeIgnoreCase("Gold");
    }

    public List<PreciousMetalEntry> getSilverEntries() {
        return preciousMetalRepository.findByTypeIgnoreCase("Silver");
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
