package mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.entity.Users;
import mypack.service.UsersService;


@WebServlet("/userRegistration")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String name = request.getParameter("userName");
		String mobile = request.getParameter("mobile");
		
		
		PrintWriter out = response.getWriter();
	    Users users = new Users();
	    users.setEmailId(userId);
	    users.setPassword(password);
	    users.setName(name);
	    users.setPhoneNo(mobile);
	    users.setType("customer");
	    
	    UsersService service  = new UsersService();
	    int count = service.insertNewUser(users);
	    if(count == 0)
	    {
	    	out.println("Error in registration. Please try again");
	    	response.setContentType("text/html;charset=UTF-8");
	    	getServletConfig().getServletContext().getRequestDispatcher("/loginsignup.jsp").include(request,response);
	    	
	    }
	    
	    else {
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("userEmailId", userId);
	    	request.setAttribute("totPersons", session.getAttribute("numberOfPersons"));
	    	getServletConfig().getServletContext().getRequestDispatcher("/bookingdetails.jsp").include(request,response);
	    }
	}

}
