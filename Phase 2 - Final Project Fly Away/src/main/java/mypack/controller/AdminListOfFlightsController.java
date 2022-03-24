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


@WebServlet("/listOfFlights")
public class AdminListOfFlightsController extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightsService service = new FlightsService();
		List<Flights> flightsList  = service.returnAdminFlightsList();
		//PrintWriter out = response.getWriter();
		//out.println(flightsList);
		request.setAttribute("flightsList",flightsList );
		getServletConfig().getServletContext().getRequestDispatcher("/adminflightslist.jsp").forward(request,response);
		
	}

}
