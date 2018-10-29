package MySQL;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Kirja.Kirja;

public class JDBCExample {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
		//	System.out.println("Creating database...");
		//	stmt = conn.createStatement();

		//	String sql = "CREATE DATABASE STUDENTS";
		//	stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
			
	
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main

	public static void tallennaKirja(Kirja opus) {

		String tekijä = opus.getTekija();
		String nimi = opus.getTeoksenNimi();
		int vuosi = opus.getJulkaisuvuosi();


		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjat", USER, PASS);

			// static final String DB_URL = "jdbc:mysql://localhost:3306/kirjat";
			String sql = "INSERT INTO kirja (kirjan_nimi, tekijä, julkaisuvuosi) values (?,?,?)";

			// the mysql insert statement

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, nimi);
			preparedStmt.setString(2, tekijä);
			preparedStmt.setInt(3, vuosi);
		
			// execute the preparedstatement
			preparedStmt.execute();

			
			System.out.println("Saving data...");
//			stmt = conn.createStatement();
//
//			stmt.execute(sql);

			System.out.println("Run ok...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main

	public static void lataaKirjat() {

		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjat", USER, PASS);

			System.out.println("Selecting data...");

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from kirja");

			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main

}// end JDBCExample