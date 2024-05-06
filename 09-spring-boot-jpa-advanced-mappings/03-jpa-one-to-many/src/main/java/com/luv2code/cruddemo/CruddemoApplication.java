package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.model.Course;
import com.luv2code.cruddemo.model.Instructor;
import com.luv2code.cruddemo.model.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			//deleteInstructor(pAppDAO);

			//findInstructorDetail(pAppDAO);

			//deleteInstructorDetail(pAppDAO);

			//createInstructorWithCourses(pAppDAO);

			//findInstructorWithCourse(pAppDAO);
			
			//findCourseForInstructor(pAppDAO);

			//findInstructorWithCoursesJoinFetch(pAppDAO);

			//updateInstructor(pAppDAO);

			//updateCourse(pAppDAO);

			//deleteInstructor(pAppDAO);

			deleteCourseById(pAppDAO);

		};
	}

	private void deleteCourseById(AppDAO pAppDAO) {
		int lId = 10;

		System.out.println("Deleting Course id: "+lId);
		pAppDAO.deleteCourseById(lId);
		System.out.println("Done !!!! ");
	}


	private void updateCourse(AppDAO pAppDAO) {
		int lId = 10;

		System.out.println("Finding Course id: "+lId);

		Course lCourse = pAppDAO.findCourseById(lId);
		System.out.println("course : "+lCourse);
		lCourse.setTitle("Advanced Java");
		pAppDAO.update(lCourse);
		System.out.println("course : "+lCourse);
		System.out.println("Done !!!! ");
	}
	private void updateInstructor(AppDAO pAppDAO) {
		int lId = 1;

		System.out.println("Finding instructor id: "+lId);

		Instructor lInstructor = pAppDAO.findInstructorById(lId);
		System.out.println("instructor : "+lInstructor);
		lInstructor.setLastName("Tester");
		pAppDAO.update(lInstructor);
		System.out.println("instructor : "+lInstructor);
		System.out.println("Done !!!! ");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO pAppDAO) {
		int lId = 1;

		System.out.println("Finding instructor id: "+lId);

		Instructor lInstructor = pAppDAO.findInstructorByIdJoinFetch(lId);
		System.out.println("instructor : "+lInstructor);
		System.out.println("associated Course : "+lInstructor.getCourses());
		System.out.println("Done !!!! ");
	}

	private void findCourseForInstructor(AppDAO pAppDAO) {
		int lId = 1;

		System.out.println("Finding instructor id: "+lId);

		Instructor lInstructor = pAppDAO.findInstructorById(lId);
		System.out.println("instructor : "+lInstructor);

		List<Course> lCourseList = pAppDAO.findCoursesByInstructorId(lId);
		System.out.println("associated the object");
		lInstructor.setCourses(lCourseList);
		System.out.println("associated Course : "+lInstructor.getCourses());
		System.out.println("Done !!!! ");
	}

	private void findInstructorWithCourse(AppDAO pAppDAO) {

		int lId = 1;

		System.out.println("Finding instructor id: "+lId);

		Instructor lInstructor = pAppDAO.findInstructorById(lId);
		System.out.println("instructor : "+lInstructor);
		System.out.println("associated Course : "+lInstructor.getCourses());
		System.out.println("Done !!!! ");
	}

	private void createInstructorWithCourses(AppDAO pAppDAO) {

		// create Instructor object
		Instructor lInstructor = new Instructor("john","cena","john@gmail.com");

		// create Instructor detail object
		InstructorDetail lInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "wwe!!!!");

		// associate the objects
		lInstructor.setInstructorDetail(lInstructorDetail);

		// create some courses
		Course lCourse1 = new Course("Java");
		Course lCourse2 = new Course("Python");

		// adding the courses to instructor
		lInstructor.add(lCourse1);
		lInstructor.add(lCourse2);

		//
		// save instructor this will also save course
		// because of cascadeType.PERSIST

		System.out.println("Saving the instructor : "+lInstructor);
		System.out.println("Saving the courses : "+lInstructor.getCourses());
		pAppDAO.save(lInstructor);
		System.out.println("Done!!!!");
	}

	private void deleteInstructorDetail(AppDAO pAppDAO) {
		int lId = 2;

		System.out.println("Deleting instructor detail id: "+lId);

		pAppDAO.deleteInstructorDetailById(lId);
		System.out.println("Done !!!! ");
	}

	private void findInstructorDetail(AppDAO pAppDAO) {
		int lId = 2;

		System.out.println("Finding instructor detail id: "+lId);

		InstructorDetail lInstructorDetail = pAppDAO.findInstructorDetailById(lId);
		System.out.println("instructor detail : "+lInstructorDetail);
		System.out.println("associated instructor : "+ lInstructorDetail.getInstructor());
		System.out.println("Done !!!! ");
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
		System.out.println("associated instructor detail : "+lInstructor.getInstructorDetail());
		System.out.println("Done !!!! ");
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
