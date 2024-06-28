package com.example.TaskManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;


    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }



    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "addmytask";
    }

    @PostMapping("/tasks")
    public String addTask(@ModelAttribute("newTask") Task newTask) {
        taskService.addTask(newTask);
        return "addmytask";
    }

    @GetMapping("/tasks/{id}")
    public String getTaskDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "taskdetails";
    }

    @DeleteMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTaskById(id);
        return "addmytask";
    }
}
