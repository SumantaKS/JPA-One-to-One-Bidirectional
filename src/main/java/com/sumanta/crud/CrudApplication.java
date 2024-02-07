package com.sumanta.crud;

import com.sumanta.crud.dao.AppDAO;
import com.sumanta.crud.entity.Instructor;
import com.sumanta.crud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor1 = new Instructor("Samuel", "Drake", "sam@gmail,com");
		InstructorDetail instructorDetail1 = new InstructorDetail("youtube.com/sam", "lying");

		instructor1.setInstructorDetail(instructorDetail1);

		appDAO.save(instructor1);

	}
}
