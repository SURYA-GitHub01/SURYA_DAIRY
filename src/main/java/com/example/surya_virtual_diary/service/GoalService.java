package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Goal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalService {

    private static final List<Goal> goals = new ArrayList<>();

        private static long goalIdCounter = 0;

    static {
        // Short-term goals
        goals.add(new Goal(++goalIdCounter, "Full Time IT Job", "short-term", "In Progress"));
        goals.add(new Goal(++goalIdCounter, "Save 1 Lakh", "short-term", "Planned"));
        goals.add(new Goal(++goalIdCounter, "Kovil poojai", "short-term", "Planned"));




        // Long-term goals
        goals.add(new Goal(++goalIdCounter, "Built First Floor", "long-term", "Planned"));
        goals.add(new Goal(++goalIdCounter, "Buy Gold Chain", "long-term", "Planned"));
        goals.add(new Goal(++goalIdCounter, "Buy Gold Bar", "long-term", "Planned"));
        goals.add(new Goal(++goalIdCounter, "Buy Silver Bar", "long-term", "Planned"));
    }

    public List<Goal> getGoals() {
        return goals;
    }
}
