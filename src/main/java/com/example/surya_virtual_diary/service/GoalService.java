package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Goal;
import com.example.surya_virtual_diary.repository.GoalRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;

    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }
}
