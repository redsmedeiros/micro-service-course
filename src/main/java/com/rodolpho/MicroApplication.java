package com.rodolpho;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rodolpho.model.Course;
import com.rodolpho.repository.CourseRepository;

@SpringBootApplication
public class MicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();

			c.setName("Angular");
			c.setCategory("front-end");

			courseRepository.save(c);
		};
	}

}
