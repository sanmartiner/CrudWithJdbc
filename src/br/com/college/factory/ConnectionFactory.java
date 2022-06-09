package br.com.college.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	/**
	 * Configure USERNAME, PASSWORD and URL(With path, port and name of database).
	 */
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/college";

	/**
	 * Method to connect with the database that has been configured before.
	 * 
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection createConnectionToMySql() throws SQLException, Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws SQLException, Exception {

		Connection conn = createConnectionToMySql();

		if (conn != null) {
			conn.close();
		}
	}
}
