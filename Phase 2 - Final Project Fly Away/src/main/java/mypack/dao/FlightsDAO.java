package mypack.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mypack.entity.Flights;
import sql.connection.MyConnection;


public class FlightsDAO {
	public List<Flights> getDistinctSource(){
		
		try {
	Connection con = MyConnection.establishConnection();
	String query = "select distinct source from flights";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	List<Flights> sources = new ArrayList<Flights>();
	while(rs.next()) {
		
		Flights f = new Flights();
		
		f.setSource(rs.getString(1));
		sources.add(f);
	}
	con.close();
	return sources;
		
	}
	
	
	catch(Exception e) {
		
		System.out.println(e);
	}
		
		return null;
}
public List<Flights> getDistinctDestination(){
		
		try {
	Connection con = MyConnection.establishConnection();
	String query = "select distinct destination from flights";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	List<Flights> destinations = new ArrayList<Flights>();
	while(rs.next()) {
		
		Flights f = new Flights();
		
		f.setDestination(rs.getString(1));
		destinations.add(f);
	}
	con.close();
	return destinations;
		
	}
	
	
	catch(Exception e) {
		
		System.out.println(e);
	}
		
		return null;
}


public int getMaximumSeats(){
	
	try {
Connection con = MyConnection.establishConnection();
String query = "select max(available_seats) from flights";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);

int  maxSeats = 0;
while(rs.next()) {
	
	
	
	maxSeats = rs.getInt(1);
	
}
con.close();
return maxSeats;
	
}


catch(Exception e) {
	
	System.out.println(e);
}
	
	return 0;
}

public List<Flights> getFlightsList(Flights f, int seats){
	
	try {
		Connection con = MyConnection.establishConnection();
		String query = "select * from flights where source = ? and destination =? and "
				+ " available_seats>= ? and departure_date =?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, f.getSource());
		st.setString(2,f.getDestination());
		st.setInt(3, seats);
		st.setDate(4, new java.sql.Date(f.getDepartureDate().getTime()));
		ResultSet rs = st.executeQuery();
		List<Flights> flightsList = new ArrayList<Flights>();
		while(rs.next()) {
			
			Flights f1 = new Flights();
			f1.setFlightNo(rs.getString(1));
			f1.setAirline(rs.getString(2));
			f1.setTime(rs.getString(5));
			f1.setCostPerPerson(rs.getInt(8));
			f1.setFlightDuration(rs.getString(9));
			f1.setSource(rs.getString(3));
			f1.setDestination(rs.getString(4));
			f1.setDepartureDate(rs.getDate(6));
			flightsList.add(f1);
		}
		con.close();
		return flightsList;
		
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	
	return null;
}

public List<Flights> getAdminFlightsList(){
	
	try {
		Connection con = MyConnection.establishConnection();
		String query = "select * from flights";
		PreparedStatement st = con.prepareStatement(query);
		
		ResultSet rs = st.executeQuery();
		List<Flights> flightsList = new ArrayList<Flights>();
		while(rs.next()) {
			
			Flights f1 = new Flights();
			f1.setFlightNo(rs.getString(1));
			f1.setAirline(rs.getString(2));
			f1.setTime(rs.getString(5));
			f1.setCostPerPerson(rs.getInt(8));
			f1.setFlightDuration(rs.getString(9));
			f1.setSource(rs.getString(3));
			f1.setDestination(rs.getString(4));
			f1.setDepartureDate(rs.getDate(6));
			flightsList.add(f1);
		}
		con.close();
		return flightsList;
		
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	
	return null;
}



public List<Flights> getAdminAirlines(){
	
	try {
Connection con = MyConnection.establishConnection();
String query = "select distinct airline from flights";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);

List<Flights> airlines = new ArrayList<Flights>();
while(rs.next()) {
	
	Flights f = new Flights();
	
	
	f.setAirline(rs.getString(1));
	airlines.add(f);
}
con.close();
return airlines;
	
}


catch(Exception e) {
	
	System.out.println(e);
}
	
	return null;
}


public List<Flights> getAdminSourceAndDestination(){
	
	try {
Connection con = MyConnection.establishConnection();
String query = "select distinct source,destination from flights";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);

List<Flights> airlines = new ArrayList<Flights>();
while(rs.next()) {
	
	Flights f = new Flights();
	
	
	f.setSource(rs.getString(1));
	f.setDestination(rs.getString(2));
	airlines.add(f);
}
con.close();
return airlines;
	
}


catch(Exception e) {
	
	System.out.println(e);
}
	
	return null;
}

public int updateTotalAvailableSeats(int totalPersons,String flightNo) {
	
	int countRows = 0;
	try {
		
		Connection con = MyConnection.establishConnection();
		String query = "update flights set available_seats = available_seats - "+
		  Integer.toString(totalPersons)+
				" where flight_no = '"+ flightNo + "'";
		
		Statement st = con.createStatement();
		 countRows = st.executeUpdate(query);
		 con.close();
		 return countRows;
	}
	
	catch(Exception e) {
		
		System.out.println(e);
	}
	return countRows;
}
}
