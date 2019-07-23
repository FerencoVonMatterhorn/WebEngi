package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.db.DBActions;
import main.java.db.DBPaymentActions;
import main.java.pojos.MonthlyPaymentPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToUserPojo;

@NoArgsConstructor
@Getter
@Setter
public class MonthlyPaymentBean {
	private List<PaymentPojo> payments;
	private List<PaymentToUserPojo> paymentToUser = new ArrayList<>();
	private MonthlyPaymentPojo monthlyPayment;

	public MonthlyPaymentBean(int monthlyPaymentID, int userID) {

		this.monthlyPayment = DBPaymentActions.findMonthlyPaymentByID(monthlyPaymentID);

		this.payments = DBPaymentActions.findPaymentsForMonthlyPaymentByUserID(monthlyPaymentID, userID);

		for (PaymentPojo paymentPojo : this.payments) {
			paymentToUser.add(DBActions.findPaymentToUserPojosByPaymentIdAndUserID(paymentPojo.getPaymentID(), userID));
		}
	}

	public double getSingleAmount(PaymentToUserPojo paymentToUserPojo, PaymentPojo payment) {
		return ((double) paymentToUserPojo.getPercentage() / 100) * payment.getAmount();
	}

	public double calculateTotal() {
		double amount = 0;
		for (int index = 0; index < payments.size(); index++) {
			amount += ((double) paymentToUser.get(index).getPercentage() / 100) * payments.get(index).getAmount();
		}

		return amount;
	}

}
