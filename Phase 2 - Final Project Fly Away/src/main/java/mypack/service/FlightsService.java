package mypack.service;

import java.util.ArrayList;
import java.util.List;

import mypack.dao.FlightsDAO;
import mypack.entity.Flights;

public class FlightsService {
	public List<Flights> returnDistinctSources() {
		FlightsDAO dao = new FlightsDAO();
		return dao.getDistinctSource();

	}
	
	public List<Flights> returnDistinctDestinations() {
		FlightsDAO dao = new FlightsDAO();
		return dao.getDistinctDestination();

	}

	
	public int returnMaximumSeats() {
		
		FlightsDAO dao = new FlightsDAO();
		return dao.getMaximumSeats();
		
	}
	
	public List<Flights> returnFlightsList(Flights f, int seats){
		
		FlightsDAO dao = new FlightsDAO();
		return dao.getFlightsList(f, seats);
		
	}
public List<Flights> returnAdminFlightsList(){
		
		FlightsDAO dao = new FlightsDAO();
		return dao.getAdminFlightsList();
		
	}
	public Flights returnSelectedFlight(List<Flights> flightsList,String flightNo) {
		//Flights selectedFlight = null;
		for(Flights f:flightsList) {
			
			if(f.getFlightNo().equals(flightNo))
				//System.out.println(f.getFlightNo());
			return f;
		}
		return null;
		
	}
	
	public List<Flights> returnAdminDistinctAirlines() {
		FlightsDAO dao = new FlightsDAO();
		return dao.getAdminAirlines();

	}
	
	public List<Flights> returnAdminDistinctSourceAndDestination() {
		FlightsDAO dao = new FlightsDAO();
		return dao.getAdminSourceAndDestination();

	}
	
	
	
	
}