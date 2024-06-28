package com.example.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public void addTask(Task newTask) {
        taskRepository.addTask(newTask);
    }

    public Task getTaskById(int id) {
        return taskRepository.getTaskById(id);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteTaskById(id);
    }
}

