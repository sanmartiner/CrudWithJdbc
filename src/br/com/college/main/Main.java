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

		Student student = new Student();
		StudentDAO studentDAO = new StudentDAO();
		
		student.setName("Martin");
		student.setAge(25);
		student.setBirthDate(new Date());
		student.setEmail("sam@college.com");
		student.setAddress("R. San Francisco, 469");
		student.setPhone("+184303301230");
		
		studentDAO.save(student);

	}

}
