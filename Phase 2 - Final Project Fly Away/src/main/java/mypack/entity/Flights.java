package mypack.entity;

import java.util.Date;

public class Flights {
	
	String flightNo;
	String airline;
	String source;
	String destination;
	String time;
	Date departureDate;
	int availableSeats;
	int costPerPerson;
	String flightDuration;
	public Flights() {
		
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getCostPerPerson() {
		return costPerPerson;
	}
	public void setCostPerPerson(int costPerPerson) {
		this.costPerPerson = costPerPerson;
	}
	public String getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	@Override
	public String toString() {
		return "Flights [flightNo=" + flightNo + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", time=" + time + ", departureDate=" + departureDate + ", availableSeats="
				+ availableSeats + ", costPerPerson=" + costPerPerson + ", flightDuration=" + flightDuration + "]";
	}
	
	

}
