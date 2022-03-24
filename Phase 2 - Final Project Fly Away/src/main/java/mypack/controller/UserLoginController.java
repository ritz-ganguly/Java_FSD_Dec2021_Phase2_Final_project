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


@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		Users u = new Users();
		u.setEmailId(userId);
		u.setPassword(password);
		UsersService service = new UsersService();
		boolean status = service.checkUserLogin(u);
		if(status == true) {
			HttpSession session = request.getSession();
			session.setAttribute("userEmailId", userId);
			session.setAttribute("totPersons", session.getAttribute("numberOfPersons"));
			getServletConfig().getServletContext().getRequestDispatcher("/bookingdetails.jsp").forward(request,response);
		}
		
		else {
			
			out.println("Invalid credentials. Please try again");
	    	response.setContentType("text/html;charset=UTF-8");
	    	getServletConfig().getServletContext().getRequestDispatcher("/userloginpage.jsp").include(request,response);
		}
	}

}
