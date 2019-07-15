package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.db.DBActions;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToUserPojo;
import main.java.pojos.UserPojo;

@Getter
@Setter
@NoArgsConstructor
public class SinglePaymentBean {

	private PaymentPojo payment;
	private List<PaymentToUserPojo> paymentToUserPojosList = new ArrayList<>();
	private List<UserPojo> userPojosList = new ArrayList<>();

	public SinglePaymentBean(PaymentPojo paymentPojo) {
		this.payment = paymentPojo;

		findPaymentToUserPojos();
		findUsersToPayment();

	}

	public void findPaymentToUserPojos() {
		paymentToUserPojosList = DBActions.getPaymentToUserPojosByPaymentId(this.payment.getPaymentID());
	}

	public void findUsersToPayment() {
		userPojosList = DBActions.getUsersToPayment(this.payment);

	}

	public String findUserNameByPtO(PaymentToUserPojo paymentToUserPojo) {
		for (UserPojo user : userPojosList) {
			if (user.getId() == paymentToUserPojo.getUser().getId()) {
				return user.getUsername();
			}
		}

		return "UserNotFound";
	}

	public double getSingleAmount(PaymentToUserPojo paymentToUserPojo) {
		return ((double) paymentToUserPojo.getPercentage() / 100) * payment.getAmount();
	}

}
