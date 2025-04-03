package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).map(task ->
                new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getCreatedAt(),
                        task.getDueDate()
                )
        ).orElse(null);
    }


    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest request) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            task.setCompleted(request.isCompleted());
            task.setDueDate(request.getDueDate());

            Task updated = taskRepository.save(task);

            return new TaskResponse(
                    updated.getId(),
                    updated.getTitle(),
                    updated.getDescription(),
                    updated.isCompleted(),
                    updated.getCreatedAt(),
                    updated.getDueDate()
            );
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
        task.setDueDate(request.getDueDate());

        Task savedTask = taskRepository.save(task);

        return new TaskResponse(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.isCompleted(),
                savedTask.getCreatedAt(),
                savedTask.getDueDate()
        );
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream().map(task ->
                new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getCreatedAt(),
                        task.getDueDate()
                )
        ).toList();
    }
}
