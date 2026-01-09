package com.example.surya_virtual_diary.models;

public class Goal {
    private Long id;
    private String description;
    private String type; // "short-term" or "long-term"
    private String status; // "planned", "in progress", "completed"

    public Goal(Long id, String description, String type, String status) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
