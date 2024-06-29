package com.example.TaskManager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TaskRepository {
    private final JdbcClient jdbcClient;

    public TaskRepository(JdbcTemplate template) {
        this.jdbcClient = JdbcClient.create(template);
    }

    public List<Task> getAllTasks() {
        return jdbcClient.sql("SELECT * FROM tasks").query(
                (rs, rowNum) -> new Task(
                        rs.getInt("task_id"),
                        rs.getString("taskName"),
                        rs.getString("taskDescription"),
                        rs.getString("tasktatus"))
        ).list();
    }

    public void addTask(Task newTask) {
        String sql = "INSERT INTO tasks (task_id,taskName, taskDescription, tasktatus) VALUES (?,?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql(sql)
                .params(newTask.getTaskId(),newTask.getTaskName(), newTask.getTaskDescription(), newTask.getTaskStatus())
                .update(keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            newTask.setTaskId(key.intValue());
        }
    }

    public Task getTaskById(int id) {
        return jdbcClient.sql("SELECT * FROM tasks WHERE task_id = :task_id")
                .params(Map.of("task_id", id))
                .query(
                        (rs, rowNum) -> new Task(
                                rs.getInt("task_id"),
                                rs.getString("taskName"),
                                rs.getString("taskDescription"),
                                rs.getString("tasktatus"))
                ).single();
    }

    public void deleteTaskById(int id) {
        jdbcClient.sql("DELETE FROM tasks WHERE task_id = :task_id")
                .params(Map.of("task_id", id))
                .update();
    }
}
