package com.exam2.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {

	public static Connection getCon() throws Exception {

		final String USER_NAME = "root";
		final String PASSWORD = "1234";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/crudexam";

		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		Class.forName(DRIVER);
		System.out.println("연결성공");
		return con;

	}

	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	public static void close (Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}

}
