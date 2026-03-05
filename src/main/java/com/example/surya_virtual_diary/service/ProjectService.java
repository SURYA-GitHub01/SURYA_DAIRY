package com.example.surya_virtual_diary.service;

import com.example.surya_virtual_diary.models.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private static final List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project("Green Commune", LocalDate.of(2024, 7, 1), LocalDate.of(2024, 8, 31), "Iyarkai Tech Lab"));
        projects.add(new Project("Seamless Community Interaction and Management", LocalDate.of(2024, 10, 1), LocalDate.of(2024, 12, 31), "Infosys Springboard"));
        projects.add(new Project("RDPS (Education University of HongKong)", LocalDate.of(2025, 9, 1),LocalDate.of(2025, 2, 28), "aTalent"));
        projects.add(new Project("Uniqa", LocalDate.of(2026, 3, 1), null, "aTalent"));
    }

    public List<Project> getProjects() {
        return projects;
    }
}
