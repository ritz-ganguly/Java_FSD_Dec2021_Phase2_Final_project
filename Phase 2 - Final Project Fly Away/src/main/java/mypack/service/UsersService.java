package mypack.service;

import mypack.dao.UsersDAO;
import mypack.entity.Users;

public class UsersService {
 public boolean checkAdminLogin(Users u) {
	 UsersDAO dao = new UsersDAO();
	 boolean status = dao.checkAdminLogin(u);
	 return status;
	 
	 
 }
 
 public int changeAdminPassword(String userId, String oldPassword,String newPassword) {
	 
	 UsersDAO dao = new UsersDAO();
	 int rowsUpdated = dao.changeAdminPassword(userId, oldPassword, newPassword);
	 return rowsUpdated;
 }
 
 public int insertNewUser(Users u) {
	 UsersDAO dao =  new UsersDAO();
	 int count = dao.insertNewUser(u);
	 
	 return count;
	 
 }
 
 public boolean checkAlreadyUser(Users u ) {
	 UsersDAO dao =  new UsersDAO();
	 boolean status = dao.checkAlreadyUser(u);
	 return status;
	 
	 
 }
 
 public boolean checkUserLogin(Users u) {
	 
	 UsersDAO dao =  new UsersDAO();
	 boolean status = dao.checkUserLogin(u);
	 return status;
 }
}
