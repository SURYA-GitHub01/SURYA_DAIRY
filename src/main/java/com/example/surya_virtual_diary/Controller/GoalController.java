package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Goal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GoalController {

    private static long goalIdCounter = 0;

    @GetMapping("/goals")
    public String goals(Model model) {
        List<Goal> allGoals = new ArrayList<>();
        // Short-term goals
        allGoals.add(new Goal(++goalIdCounter, "Complete Spring Boot project", "short-term", "In Progress"));
        allGoals.add(new Goal(++goalIdCounter, "Learn Docker basics", "short-term", "Planned"));
        allGoals.add(new Goal(++goalIdCounter, "Finish 'Clean Code' book", "short-term", "Completed"));

        // Long-term goals
        allGoals.add(new Goal(++goalIdCounter, "Become a Senior Software Engineer", "long-term", "In Progress"));
        allGoals.add(new Goal(++goalIdCounter, "Contribute to open source project", "long-term", "Planned"));
        allGoals.add(new Goal(++goalIdCounter, "Master a new programming language", "long-term", "Planned"));

        List<Goal> shortTermGoals = allGoals.stream()
                .filter(goal -> "short-term".equals(goal.getType()))
                .collect(Collectors.toList());

        List<Goal> longTermGoals = allGoals.stream()
                .filter(goal -> "long-term".equals(goal.getType()))
                .collect(Collectors.toList());

        model.addAttribute("shortTermGoals", shortTermGoals);
        model.addAttribute("longTermGoals", longTermGoals);
        model.addAttribute("totalShortTermGoals", shortTermGoals.size());
        model.addAttribute("totalLongTermGoals", longTermGoals.size());
        model.addAttribute("view", "goals");
        return "layout";
    }
}