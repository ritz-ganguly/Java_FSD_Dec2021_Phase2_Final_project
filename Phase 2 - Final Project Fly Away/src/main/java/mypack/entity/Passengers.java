package mypack.entity;

public class Passengers {
  private String passengerName;
  private int passengerAge;
  public Passengers() {
	// TODO Auto-generated constructor stub
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public int getPassengerAge() {
	return passengerAge;
}
public void setPassengerAge(int passengerAge) {
	this.passengerAge = passengerAge;
}
@Override
public String toString() {
	return "Passengers [passengerName=" + passengerName + ", passengerAge=" + passengerAge + "]";
}
  
}
