package com.example.TaskManager;

public class Task {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskStatus;

    public Task() {}

    public Task(int taskId, String taskName, String taskDescription, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    // Getters and setters

    public int getTaskId() {
        return taskId;
    }


        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

        public String getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
        }

        // toString method for printing object

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", taskDescription='" + taskDescription + '\'' +
                    ", taskStatus='" + taskStatus + '\'' +
                    '}';
        }
    }