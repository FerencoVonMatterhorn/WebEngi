package main.java.util;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.db.DBGroupActions;
import main.java.db.DBPaymentActions;
import main.java.db.DBUserActions;
import main.java.pojos.GroupPojo;
import main.java.pojos.MonthlyPaymentPojo;
import main.java.pojos.MonthlyPaymentToGroupPojo;
import main.java.pojos.MonthlyPaymentToPaymentPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToGroupPojo;
import main.java.pojos.PaymentToUserPojo;
import main.java.pojos.UserPojo;

public class PaymentUtil {

	private PaymentUtil() {
		// May be empty.
	}

	// TODO: logging
	public static int createPayment(Map<String, String> inModalValues) {
		int groupId = Integer.parseInt(inModalValues.get("groupId"));
		PaymentPojo payment = new PaymentPojo();
		payment.setAmount(Double.valueOf(inModalValues.get("paymentValue")));
		payment.setDateCreated(OffsetDateTime.now());
		payment.setGroupName(DBGroupActions.findGroupByID(groupId).getGroupName());
		payment.setPaymentDescription(inModalValues.get("paymentdescription"));
		DBPaymentActions.savePayment(payment);

		Map<String, String> users = InputDataValidationUtil.getUserStrings(inModalValues);
		for (String userString : users.keySet()) {
			Optional<UserPojo> user = DBUserActions.findUserByName(inModalValues.get(userString));
			if (user.isPresent()) {
				PaymentToUserPojo paymentToUser = new PaymentToUserPojo();
				paymentToUser.setPayment(payment);
				paymentToUser.setUser(user.get());
				paymentToUser.setPercentage(Integer.parseInt(inModalValues.get(userString + "P")));
				DBPaymentActions.savePaymentToUser(paymentToUser);
			}
		}

		PaymentToGroupPojo paymentToGroup = new PaymentToGroupPojo();
		paymentToGroup.setGroup(DBGroupActions.findGroupByID(groupId));
		paymentToGroup.setPayment(payment);
		DBPaymentActions.savePaymentToGroup(paymentToGroup);

		MonthlyPaymentPojo monthlyPament = DBPaymentActions.findMonthlyPaymentByID(DBPaymentActions.findRecentMonthlyPaymentbyGroupID(groupId));
		MonthlyPaymentToPaymentPojo monthlyPamentToPayment = new MonthlyPaymentToPaymentPojo();
		monthlyPamentToPayment.setMonthlyPayment(monthlyPament);
		monthlyPamentToPayment.setPayment(payment);
		DBPaymentActions.saveMonthlyPaymentToPayment(monthlyPamentToPayment);

		return payment.getPaymentID();
	}

	// TODO Logging / code comment
	public static void updateMonthlyPayment(int inUserID) {
		List<GroupPojo> groups = DBGroupActions.findAllGroupsByUserID(inUserID);
		for (GroupPojo groupPojo : groups) {
			int monthlyPaymentID = DBPaymentActions.findRecentMonthlyPaymentbyGroupID(groupPojo.getGroupID());
			if (monthlyPaymentID == -1) {
				MonthlyPaymentPojo newPojo = new MonthlyPaymentPojo();
				newPojo.setDateCreated(OffsetDateTime.now());
				newPojo.setDateUntil(OffsetDateTime.now().plusMonths(1).plusDays(7));
				MonthlyPaymentToGroupPojo mptg = new MonthlyPaymentToGroupPojo();
				mptg.setGroup(groupPojo);
				mptg.setMonthlyPayment(newPojo);
				DBPaymentActions.saveMonthlyPayment(newPojo);
				DBPaymentActions.saveMonthlyPaymentToGroup(mptg);
			} else if (!paymentIsFromCurrentMonth(monthlyPaymentID)) {
				MonthlyPaymentPojo newMonthlyPayment = new MonthlyPaymentPojo();
				newMonthlyPayment.setDateCreated(OffsetDateTime.now());
				newMonthlyPayment.setDateUntil(OffsetDateTime.now().plusMonths(1).plusDays(7));
				MonthlyPaymentToGroupPojo mptg = new MonthlyPaymentToGroupPojo();
				mptg.setMonthlyPayment(newMonthlyPayment);
				DBPaymentActions.saveMonthlyPayment(newMonthlyPayment);
				DBPaymentActions.saveMonthlyPaymentToGroup(mptg);
			}
		}
	}

	private static boolean paymentIsFromCurrentMonth(int monthlyPaymentID) {
		return DBPaymentActions.findMonthlyPaymentByID(monthlyPaymentID).getDateCreated().getMonth().equals(OffsetDateTime.now().getMonth());
	}

}
