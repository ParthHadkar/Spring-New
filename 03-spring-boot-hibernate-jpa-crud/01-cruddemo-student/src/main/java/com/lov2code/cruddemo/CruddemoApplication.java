package com.lov2code.cruddemo;

import com.lov2code.cruddemo.dao.StudentDAO;
import com.lov2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Student");
		int deletedRows = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+deletedRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6;
		System.out.println("Deleting Student with id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve the user base on id
		int studentId = 1;
		System.out.println("Getting Student with id: "+studentId);
		Student student = studentDAO.findById(studentId);
		// change firstname
		System.out.println("Updating Student");
		student.setFirstName("Parth");
		// update the student
		studentDAO.update(student);
		// display the updated student
		System.out.println("Updated Student: "+student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get the list of students
		List<Student> students = studentDAO.findByLastName("Hadkar");
		// display the list of students
		for(Student student: students){
			System.out.println("Student: "+student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get the list of students
		List<Student> students = studentDAO.findAll();
		// display the list of students
		for(Student student: students){
			System.out.println("Student: "+student);
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create mutiple students
		System.out.println("Creating new 3 student object");
		Student student1 = new Student("nitin", "gadhi","nitin@gmail.com");
		Student student2 = new Student("nikhil", "etame","nikhil@gmail.com");
		Student student3 = new Student("deepak", "phejale","deepak@gmail.com");
		Student student4 = new Student("rishi", "echale","rishi@gmail.com");
		// save the students
		System.out.println("Saving student");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student student = new Student("Parth", "Hadkar","parth@gmail.com");
		// save the student object
		studentDAO.save(student);
		// display the id of save students
		System.out.println("Saved Student. Generated Id: "+student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student student = new Student("Parth", "Hadkar","parth@gmail.com");
		// save the student object
		studentDAO.save(student);
		// display the id of save students
		int id = student.getId();
		System.out.println("Saved Student. Generated Id: "+id);
		// retrieve student base on id
		System.out.println("Retrieving Student Using Generated Id: "+id);
		Student studentDb = studentDAO.findById(student.getId());
		// display the student
		System.out.println("Found the Student. "+studentDb);
	}

}
