package com.example.TaskManager;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TaskManagerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
    @Bean
	public TaskController.AuthInterceptor authInterceptor()
	{
		return new TaskController.AuthInterceptor();
	}
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor())
				.addPathPatterns("/tasks/**")
				.excludePathPatterns("/", "/login", "/logout");
	}
}
