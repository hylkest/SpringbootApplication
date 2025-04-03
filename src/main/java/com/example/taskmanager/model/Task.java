package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.FutureOrPresent;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titel mag niet leeg zijn")
    @Size(max = 100, message = "Titel mag maximaal 100 tekens zijn")
    private String title;

    @Size(max = 250, message = "Beschrijving mag maximaal 250 tekens zijn")
    private String description;

    private boolean completed;

    private LocalDateTime createdAt;

    @FutureOrPresent(message = "Deadline mag niet in het verleden liggen")
    private LocalDateTime dueDate;

    public Task() {
        this.createdAt = LocalDateTime.now(); // automatisch tijdstip bij aanmaak
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
