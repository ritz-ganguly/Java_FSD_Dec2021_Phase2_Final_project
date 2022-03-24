package mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mypack.entity.Users;
import sql.connection.MyConnection;

public class UsersDAO {
public boolean checkAdminLogin(Users u) {
	boolean status=false;
	try {
		Connection con = MyConnection.establishConnection();
		String query = "select * from users where email_id =? and password = ?"
				+ " and type='admin' ";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,u.getEmailId());
		st.setString(2, u.getPassword());
		ResultSet rs = st.executeQuery();
		if(rs.next())
			status = true;
		con.close();
		
		
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	
	return status;
}

public int changeAdminPassword(String userId, String oldPassword,String newPassword) {
	int rowsUpdated = 0;
	try {
		Connection con = MyConnection.establishConnection();
		String query = "update users set password = ? where password = ? and "
				+ " email_id = ? and type='admin'";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, newPassword);
		pst.setString(2, oldPassword);
		pst.setString(3, userId);
		rowsUpdated = pst.executeUpdate();
		con.close();
		
		
	}
	
	catch(Exception e) {
		
		System.out.println(e);
	}
	return rowsUpdated;
	
}

public int insertNewUser(Users u ) {
	
	int count = 0;
	
	try {
		Connection con = MyConnection.establishConnection();
		String query = "insert into users values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, u.getEmailId());
		st.setString(2, u.getPassword());
		st.setString(3, u.getName());
		st.setString(4, u.getPhoneNo());
		st.setString(5, u.getType());
		
		 count = st.executeUpdate();
		 con.close();
		
		
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	return count;
}


public boolean checkAlreadyUser(Users u) {
	
	boolean status = false;
	try {
		
		Connection con = MyConnection.establishConnection();
		String query = "select * from users where email_id = ? and type = 'customer' ";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,u.getEmailId());
		ResultSet rs = st.executeQuery();
		if(rs.next())
			status = true;
	}
	
	catch(Exception e) {
		
		System.out.println(e);
	}
	return status;
}


public boolean checkUserLogin(Users u) {
	boolean status=false;
	try {
		Connection con = MyConnection.establishConnection();
		String query = "select * from users where email_id =? and password = ?"
				+ " and type='customer' ";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,u.getEmailId());
		st.setString(2, u.getPassword());
		ResultSet rs = st.executeQuery();
		if(rs.next())
			status = true;
		con.close();
		
		
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	
	return status;
}
}
