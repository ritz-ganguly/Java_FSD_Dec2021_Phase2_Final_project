package mypack.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.entity.Flights;
import mypack.service.FlightsService;


@WebServlet("/wel")
public class WelcomeController extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		FlightsService flightService = new FlightsService();
		List<Flights> distinctFlightsSources  = flightService.returnDistinctSources();
		//System.out.println(distinctFlightsSources);
		request.setAttribute("distinctSources",distinctFlightsSources );
		
		List<Flights> distinctFlightsDestinations  = flightService.returnDistinctDestinations();
		//System.out.println(distinctFlightsSources);
		request.setAttribute("distinctDestinations",distinctFlightsDestinations );
		
		
	    //out.println(distinctFlightsSources.get(0).getSource());
		
		
		//String p  = request.getParameter("birthday");
		//out.print(p);
		
		int maxSeats = flightService.returnMaximumSeats();
		request.setAttribute("maxSeats", maxSeats);
		
		
		getServletConfig().getServletContext().getRequestDispatcher("/homepage.jsp").forward(request,response);
		
		
		
	}

}
