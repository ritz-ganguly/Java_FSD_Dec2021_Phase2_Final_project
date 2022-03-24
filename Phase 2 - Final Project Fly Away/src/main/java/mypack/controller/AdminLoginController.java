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

import mypack.entity.Users;
import mypack.service.UsersService;


@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userId");
		String password = request.getParameter("password");
		Users u = new Users();
		u.setEmailId(userid);
		u.setPassword(password);
		UsersService us = new UsersService();
		boolean status = us.checkAdminLogin(u);
		PrintWriter out= response.getWriter();
		//out.println(status);
		
		if(status == true) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			response.sendRedirect("adminhome.jsp");
		}
		
		else {
			  out.print("invalid userid/password");
			  response.setContentType("text/html;charset=UTF-8");
			  RequestDispatcher rd=request.getRequestDispatcher("adminlogin.jsp");  
		        rd.include(request, response); 
		}
	}

}
