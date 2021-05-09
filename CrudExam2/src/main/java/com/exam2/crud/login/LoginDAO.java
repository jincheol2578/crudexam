package com.exam2.crud.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.exam2.crud.DBUtils;

public class LoginDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static void signup(LoginVO vo) {
		final String sql = " INSERT INTO t_user (username, password) "
				+ " VALUES ( ? , ? ) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,vo.getUserName());
			ps.setString(2, vo.getPassword());
			ps.executeUpdate();
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
	}

	public static boolean check(LoginVO vo) {
		final String sql = " SELECT username FROM t_user WHERE username = ? ";
		boolean x = false;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUserName());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				x = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return x;
	}
	
}
