package com.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;

public class TaskRequest {

    @NotBlank(message = "Titel mag niet leeg zijn")
    @Size(max = 100, message = "Titel mag maximaal 100 tekens zijn")
    private String title;

    @Size(max = 250, message = "Beschrijving mag maximaal 250 tekens zijn")
    private String description;

    @FutureOrPresent(message = "Deadline mag niet in het verleden liggen")
    private LocalDateTime dueDate;

    private boolean completed;

    // Getters en setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
