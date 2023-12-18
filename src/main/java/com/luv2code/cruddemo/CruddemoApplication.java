package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryforStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting");
		int rows = studentDAO.deleteAllStudents();
		System.out.println(rows + " rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 2;

		System.out.println("Deleting student with id " + studentId);

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student");
		myStudent.setLast_name("Rogers");

		studentDAO.update(myStudent);

		System.out.println(myStudent);


	}

	private void queryforStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		for (Student theStudent : theStudents){
			System.out.println(theStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student theStudent : theStudents){
			System.out.println(theStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new Student obj");
		Student tempStudent = new Student("Bucky","Barnes","bucky@yahoo.com");

		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student Id: " + theId);

		System.out.println("Retreiving the student with the id: " + theId);

		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating new Student obj");
		Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Mary", "Doe", "mary@gmail.com");
		Student tempStudent3 = new Student("Ben", "Doe", "ben@gmail.com");

		System.out.println("Saving ");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new Student obj");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		System.out.println("Saving stu");
		studentDAO.save(tempStudent);

		System.out.println("saved student id: " + tempStudent.getId());

	}

}
