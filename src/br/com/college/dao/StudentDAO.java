package br.com.college.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.college.factory.ConnectionFactory;
import br.com.college.model.Student;

public class StudentDAO {

	public void save(Student student) throws SQLException {

		String sql = "INSERT INTO students(name, age, birthDate, address, phone, email) VALUES(?, ?, ?, ?, ?, ?) ";

		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, student.getName());
			pstm.setInt(2, student.getAge());
			pstm.setDate(3, new Date(student.getBirthDate().getTime()));
			pstm.setString(4, student.getAddress());
			pstm.setString(5, student.getPhone());
			pstm.setString(6, student.getEmail());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> getStudents() {

		String sql = "SELECT * From college.students";

		List<Student> students = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Recovery data on DataBase
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Student student = new Student();

				student.setId(rset.getInt(1));
				student.setName(rset.getString(2));
				student.setAge(rset.getInt(3));
				student.setBirthDate(rset.getDate(4));
				student.setAddress(rset.getString(5));
				student.setPhone(rset.getString(6));
				student.setEmail(rset.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return students;

	}

	public Student getStudentsById(int id) {

		String sql = "SELECT * From college.students WHERE id VALUES(?) ";

		Student student = new Student();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Recovery data on DataBase
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			student.setId(rset.getInt(1));
			student.setName(rset.getString(2));
			student.setAge(rset.getInt(3));
			student.setBirthDate(rset.getDate(4));
			student.setAddress(rset.getString(5));
			student.setPhone(rset.getString(6));
			student.setEmail(rset.getString(7));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return student;

	}

	public void update(Student student) throws SQLException {

		String sql = "UPDATE students SET name = ?, age = ?, birthDate = ?, address = ?, phone = ?, email = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, student.getName());
			pstm.setInt(2, student.getAge());
			pstm.setDate(3, new Date(student.getBirthDate().getTime()));
			pstm.setString(4, student.getAddress());
			pstm.setString(5, student.getPhone());
			pstm.setString(6, student.getEmail());

			pstm.setInt(7, student.getId());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
				}
				conn.close();

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteById(int id) {

		String sql = "DELETE FROM contatos WHERE id = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySql();

			pstm = (PreparedStatement) conn.prepareCall(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
