package br.com.college.main;

import java.sql.SQLException;
import java.util.Date;

import br.com.college.dao.StudentDAO;
import br.com.college.model.Student;
/**
 * Class to test the comunication with the database
 * @author David
 *
 */
public class Main {

	public static void main(String[] args) throws SQLException {

		Student student1 = new Student();
		StudentDAO studentDAO = new StudentDAO();
		
		
		/**
		 * Test save
		 */
		
		student1.setName("Martin");
		student1.setAge(25);
		student1.setBirthDate(new Date());
		student1.setEmail("sam@college.com");
		student1.setAddress("R. San Francisco, 469");
		student1.setPhone("+184303301230");
		
		studentDAO.save(student1);
		
		/**
		 * Test update
		 */
		Student student2 = new Student();
		student2.setName("Martin");
		student2.setAge(25);
		student2.setBirthDate(new Date());
		student2.setEmail("sam@college.com");
		student2.setAddress("R. San Francisco, 469");
		student2.setPhone("+184303301230");
		
		studentDAO.update(student2);
		
		/**
		 * Test list Students
		 */
		
		for(Student s : studentDAO.getStudents()) {
			System.out.println("Student: "+s.getName());
		}
		
		/**
		 * Delete by Id
		 */
		
		studentDAO.deleteById(1);

	}

}
