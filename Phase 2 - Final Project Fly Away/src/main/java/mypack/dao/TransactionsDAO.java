package mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mypack.entity.Transactions;
import sql.connection.MyConnection;

public class TransactionsDAO {
public int insertIntoTransactionsTable(Transactions t) {
	
	int countRows = 0;
	try {
		Connection con = MyConnection.establishConnection();
		String query = "insert into transactions values(?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, t.getEmailId());
		st.setString(2, t.getFlightNo());
		st.setInt(3, t.getTotalPassengers());
		countRows = st.executeUpdate();
		con.close();
		return countRows;
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	return countRows;
}
}
