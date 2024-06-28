package com.example.TaskManager;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TaskManagerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}


}
