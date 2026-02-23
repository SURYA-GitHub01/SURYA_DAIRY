package com.example.surya_virtual_diary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GOALS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type; // "short-term" or "long-term"
    private String status; // "planned", "in progress", "completed"

    public Goal(String description, String type, String status) {
        this.description = description;
        this.type = type;
        this.status = status;
    }
}
