package com.example.personmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;






public class PersonOp {
	
	public static boolean insertPerson(Person pr) {
		boolean f = false;
		try {
			
			Connection con = ConnectionProvider.createCon();
			String sql = "insert into users(uname, uphone, ucity) values (?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, pr.getName());
			pstm.setString(2, pr.getPhone());
			pstm.setString(3, pr.getCity());
			
			pstm.executeUpdate();
			
			f = true;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return f;
	}
	
	public static boolean deletePerson(int id) {
		boolean f = false;
		
		try {
			
			Connection con = ConnectionProvider.createCon();
			String sql = "DELETE FROM users where uid = ?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.executeUpdate();
			
			f = true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}
	
	public static boolean updatePerson(int id, String state, String value) {
		boolean f = false;
		String stat = "u"+ state.toLowerCase();
		try {
			Connection con = ConnectionProvider.createCon();
			String sql = "UPDATE users SET " + stat + " = ? where uid = ?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, value);
			pstm.setInt(2, id);
			
			pstm.executeUpdate();
			
			f = true;
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return f;
	}
	
	public static void showPersons() {
		try {
			Connection con = ConnectionProvider.createCon();
			String sql = "SELECT * FROM users;";
			Statement stm = con.createStatement();
			
			ResultSet set = stm.executeQuery(sql);
			
			while(set.next()) {
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);
				System.out.println("+--------------------+");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
