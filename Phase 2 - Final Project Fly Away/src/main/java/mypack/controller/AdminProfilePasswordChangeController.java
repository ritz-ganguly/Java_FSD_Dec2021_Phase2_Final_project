package mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.service.UsersService;


@WebServlet("/adminProfilePasswordChange")
public class AdminProfilePasswordChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userid");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword1");
		PrintWriter out = response.getWriter();
		UsersService us = new UsersService();
		int rowsUpdated = us.changeAdminPassword(userId, oldPassword, newPassword);
		
		if(rowsUpdated == 0) {
			
			out.println("Recheck your old password");
			response.setContentType("text/html;charset=UTF-8");
			  RequestDispatcher rd=request.getRequestDispatcher("adminpasswordchangepage.jsp");  
		        rd.include(request, response); 
		}
		
		else {
			
			response.sendRedirect("adminhome.jsp");
		}
		
	}

}
