package mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.entity.Flights;
import mypack.service.FlightsService;


@WebServlet("/selectedFlight")
public class SelectedFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//int persons = (int) session.getAttribute("numberOfPersons");
		PrintWriter out = response.getWriter();
		//out.println(persons);
		String flightNo = request.getParameter("flightNo");
		//out.println(flightNo.length());
		
		
	List<Flights> flightsList = (ArrayList<Flights>) session.getAttribute("flightsList");
	
	/*
	Flights selectedFlight = null;
	for(Flights f:flightsList) {
		
		if(f.getFlightNo()==flightNo)
			selectedFlight = f;
	}
	*/
	
	FlightsService flightService = new FlightsService();
	Flights selectedFlight = flightService.returnSelectedFlight(flightsList, flightNo);
	//out.println(selectedFlight);
	
	session.setAttribute("selectedFlight", selectedFlight);
	getServletConfig().getServletContext().getRequestDispatcher("/loginsignup.jsp").forward(request,response);
	}

}
