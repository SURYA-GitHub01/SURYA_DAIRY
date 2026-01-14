package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Goal;
import com.example.surya_virtual_diary.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/goals")
    public String goals(Model model) {
        List<Goal> allGoals = goalService.getGoals();

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