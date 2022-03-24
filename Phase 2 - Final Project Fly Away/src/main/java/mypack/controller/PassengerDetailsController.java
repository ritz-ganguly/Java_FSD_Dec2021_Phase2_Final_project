package mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.entity.Passengers;


@WebServlet("/passengerDetails")
public class PassengerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		List<Passengers> list1 = new ArrayList<>();
		HttpSession session = request.getSession();
		int totPersons = (int) session.getAttribute("totPersons");
		
		for(int i=1; i<=totPersons;i++) {
			String name = request.getParameter("passengerName"+i);
			int age = Integer.parseInt( request.getParameter("passengerAge" + i));
			Passengers p = new Passengers();
			p.setPassengerName(name);
			p.setPassengerAge(age);
			list1.add(p);
			
		}
		
		session.setAttribute("passengers", list1);
		getServletConfig().getServletContext().getRequestDispatcher("/carddetails.jsp").forward(request,response);
		
	}

}
