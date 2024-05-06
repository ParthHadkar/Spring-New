package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.model.Instructor;
import com.luv2code.cruddemo.model.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO pAppDAO){
		return runner -> {
			//System.out.println("Hello World");
			//createInstructor(pAppDAO);

			//findInstructor(pAppDAO);

			deleteInstructor(pAppDAO);
		};
	}

	private void deleteInstructor(AppDAO pAppDAO) {
		int lId = 1;

		System.out.println("Deleting instructor id: "+lId);

		pAppDAO.deleteInstructorById(lId);
		System.out.println("Done !!!! ");
	}

	private void findInstructor(AppDAO pAppDAO) {

		int lId = 2;

		System.out.println("Finding instructor id: "+lId);

		Instructor lInstructor = pAppDAO.findInstructorById(lId);
		System.out.println("instructor : "+lInstructor);
		System.out.println("instructor detail : "+lInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO pAppDAO) {

		// create Instructor object
		Instructor lInstructor = new Instructor("john","cena","john@gmail.com");

		// create Instructor detail object
		InstructorDetail lInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "wwe!!!!");

		// associate the objects
		lInstructor.setInstructorDetail(lInstructorDetail);

		// save the instructor
		//
		//
		// this will also save the instructor detail object becasuse of CascadeType.ALL

		System.out.println("saving instructor :: "+lInstructor);
		pAppDAO.save(lInstructor);
		System.out.println("Done. !!!!");
	}

}
