package com.example.TaskManager;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

@Controller
public class TaskController {

    private final TaskService taskService;


    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }
  @Controller
  public static class AuthInterceptor implements HandlerInterceptor{
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          HttpSession session = request.getSession();
          String username = (String) session.getAttribute("username");
          if (username == null) {
              response.sendRedirect("/?error=login");
              return false;
          }
          return true;
      }
  }
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, HttpSession session) {

        session.setAttribute("username", username);

        return "redirect:/tasks";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("username");

        return "redirect:/tasks";
    }
    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "addmytask";
    }

    @PostMapping("/tasks")
    public String addTask(@ModelAttribute("newTask") Task newTask) {
        taskService.addTask(newTask);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTaskDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "taskdetails";
    }

    @DeleteMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }
}
