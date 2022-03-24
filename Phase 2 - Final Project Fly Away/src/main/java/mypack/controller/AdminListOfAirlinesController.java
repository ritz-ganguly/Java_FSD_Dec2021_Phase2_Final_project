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

@WebServlet("/airlines")
public class AdminListOfAirlinesController extends HttpServlet {
	
       

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightsService flightService = new FlightsService();
		List<Flights> airlinesList  = flightService.returnAdminDistinctAirlines();
		PrintWriter out = response.getWriter();
		//out.println(airlinesList);
		request.setAttribute("airlinesList",airlinesList);
		getServletConfig().getServletContext().getRequestDispatcher("/adminairlineslist.jsp").forward(request,response);
	}

}
