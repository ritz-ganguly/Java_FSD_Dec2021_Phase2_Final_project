package mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.entity.Flights;
import mypack.service.FlightsService;


@WebServlet("/booking")
public class BookingController extends HttpServlet {
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dt = request.getParameter("travelday");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int persons = Integer.parseInt(request.getParameter("persons"));
		PrintWriter out = response.getWriter();
		/*
	    out.println(dt);
		out.println(source);
		out.println(destination);
		out.println(persons);
		*/
		Flights f  = new Flights();
		try {
			f.setDepartureDate(new SimpleDateFormat("yyyy-mm-dd").parse(dt));
			f.setSource(source);
			f.setDestination(destination);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FlightsService flightService = new FlightsService();
		List<Flights> flightsList  = flightService.returnFlightsList(f, persons);
		request.setAttribute("flightsList",flightsList );
		request.setAttribute("numberOfPersons", persons);
		getServletConfig().getServletContext().getRequestDispatcher("/flightslist.jsp").forward(request,response);
	}

}
