package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projectList = new ArrayList<>();
        // Existing project (past)
        projectList.add(new Project("Green Commune", LocalDate.of(2024, 7, 01),LocalDate.of(2024, 8, 31) , "Iyarkai Tech Lab"));

        projectList.add(new Project("Seamless Community Interaction and Management", LocalDate.of(2024, 10, 01),LocalDate.of(2024, 12, 31) , "Infosys Springboard"));

        projectList.add(new Project("RDPS (Education University of HongKong)", LocalDate.of(2025, 9, 01), LocalDate.of(2025, 12, 31), "aTalent"));
        // A past project
        projectList.add(new Project("DHL", LocalDate.of(2026, 1, 01), null, "aTalent"));

        String previousCompanyName = null;
        for (Project project : projectList) {
            if (previousCompanyName == null || !previousCompanyName.equals(project.getCompanyName())) {
                project.setShouldHighlightCompanyName(true);
            }
            previousCompanyName = project.getCompanyName();
        }

        model.addAttribute("projects", projectList);
        model.addAttribute("totalProjects", projectList.size());
        model.addAttribute("view", "projects");
        return "layout";
    }
}
