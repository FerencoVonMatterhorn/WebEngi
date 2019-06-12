package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import main.java.db.DBActions;
import main.java.pojos.PaymentPojo;

@Setter
@Getter
public class PaymentOverviewBean {

	private List<PaymentPojo> payments = new ArrayList<>();
	private List<Integer> test = new ArrayList<>();
	private int itemsPerPage = 8;
	private long pages;
	private int shownPage;

	public PaymentOverviewBean() {
		shownPage = 1;

		for (int i = 0; i < 15; i++) {
			test.add(i);
		}
	}

	public void calculatePages(int userID) {
		long paymentsAmount = DBActions.getPaymentAmount(userID);

		System.out.println(paymentsAmount);

		pages = paymentsAmount % itemsPerPage == 0 ? paymentsAmount / itemsPerPage : paymentsAmount / itemsPerPage + 1;
	}

	public void getPaymentsForPage(int userID) {
		int limitstart = shownPage == 1 ? 0 : itemsPerPage * (shownPage - 1);

		payments = DBActions.getPaymentsForSpecificPage(limitstart, itemsPerPage, userID);
		System.out.println(payments.size());

	}

}
