package com.example.surya_virtual_diary.Controller;

import com.example.surya_virtual_diary.models.Project;
import com.example.surya_virtual_diary.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projectList = projectService.getProjects();

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
