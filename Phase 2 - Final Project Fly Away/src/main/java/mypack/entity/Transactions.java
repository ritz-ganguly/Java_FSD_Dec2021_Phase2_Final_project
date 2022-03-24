package mypack.entity;

public class Transactions {

	
	String emailId;
	String flightNo;
	int totalPassengers;
	
	public Transactions() {
		
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public int getTotalPassengers() {
		return totalPassengers;
	}
	public void setTotalPassengers(int totalPassengers) {
		this.totalPassengers = totalPassengers;
	}
	@Override
	public String toString() {
		return "Transactions [emailId=" + emailId + ", flightNo=" + flightNo + ", totalPassengers=" + totalPassengers
				+ "]";
	}
	
	
}
