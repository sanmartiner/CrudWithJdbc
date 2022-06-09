package br.com.college.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.college.factory.ConnectionFactory;
import br.com.college.model.Student;

public class StudentDAO {

	public void save(Student student) throws SQLException {

		String sql = "INSERT INTO student(name, age, birthDate, address, phone, email) VALUES(?, ?, ?, ?, ?, ?) ";

		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, student.getName());
			pstm.setInt(2, student.getAge());
			pstm.setDate(3, (java.sql.Date) new Date(student.getBirthDate().getTime()));
			pstm.setString(4, student.getAddress());
			pstm.setLong(5, student.getPhone());
			pstm.setString(6, student.getEmail());
						
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
