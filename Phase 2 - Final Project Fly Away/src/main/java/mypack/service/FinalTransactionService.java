package mypack.service;

import mypack.dao.FlightsDAO;
import mypack.dao.TransactionsDAO;
import mypack.entity.Transactions;

public class FinalTransactionService {
public synchronized void updateTotalAvailableSeats(int totalPersons,String flightNo,
		Transactions t) {
		
		FlightsDAO dao = new FlightsDAO();
		dao.updateTotalAvailableSeats(totalPersons, flightNo);
		TransactionsDAO dao2 = new TransactionsDAO();
		dao2.insertIntoTransactionsTable(t);
		
}
}
