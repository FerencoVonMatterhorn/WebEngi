package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.db.DBPaymentActions;
import main.java.pojos.PaymentPojo;

@NoArgsConstructor
@Setter
@Getter
public class PaymentOverviewBean {

	private List<PaymentPojo> payments = new ArrayList<>();
	private int itemsPerPage = 9;
	private long pages;
	private int shownPage = 1;

	public void calculatePages(int userID) {
		long paymentsAmount = DBPaymentActions.getAmountOfPayments(userID);
		pages = paymentsAmount % itemsPerPage == 0 ? paymentsAmount / itemsPerPage : paymentsAmount / itemsPerPage + 1;
	}

	public void getPaymentsForPage(int userID) {
		int limitstart = shownPage == 1 ? 0 : itemsPerPage * (shownPage - 1);
		payments = DBPaymentActions.findPaymentsForSpecificPage(limitstart, itemsPerPage, userID);
	}

}
