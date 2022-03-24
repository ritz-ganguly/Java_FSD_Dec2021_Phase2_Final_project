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


@WebServlet("/sourceAndDestination")
public class AdminSourceAndDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FlightsService flightService = new FlightsService();
		List<Flights> sourceDestinationList  = flightService.returnAdminDistinctSourceAndDestination();
	
		PrintWriter out = response.getWriter();
		//out.println(sourceDestinationList);
		request.setAttribute("sourceDestinationList",sourceDestinationList);
		getServletConfig().getServletContext().getRequestDispatcher("/adminsourcedestinationlist.jsp").forward(request,response);
	}

}
