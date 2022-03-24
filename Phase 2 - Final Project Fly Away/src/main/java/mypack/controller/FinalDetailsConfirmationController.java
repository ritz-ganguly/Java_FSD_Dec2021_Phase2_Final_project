package mypack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypack.entity.Flights;
import mypack.entity.Transactions;
import mypack.service.FinalTransactionService;
import mypack.service.FlightsService;


@WebServlet("/finalDetailsConfirmation")
public class FinalDetailsConfirmationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		Flights f = (Flights) session.getAttribute("selectedFlight");
		String flightNo = f.getFlightNo();
		
		int totPersons = (int) session.getAttribute("totPersons");
		
		Transactions t = new Transactions();
		t.setEmailId((String) session.getAttribute("userEmailId"));
		t.setFlightNo(flightNo);
		t.setTotalPassengers(totPersons);
		
		FinalTransactionService service = new FinalTransactionService();
		service.updateTotalAvailableSeats(totPersons, flightNo,t);
		response.sendRedirect("homepage.jsp");
	}

}
