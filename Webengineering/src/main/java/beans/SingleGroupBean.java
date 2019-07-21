package main.java.beans;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.db.DBPaymentActions;
import main.java.pojos.MonthlyPaymentPojo;

@Getter
@Setter
@NoArgsConstructor
public class SingleGroupBean {

	private String name;

	private String description;

	private String users;

	private List<MonthlyPaymentPojo> monthlyPayments;

	public SingleGroupBean(int groupID) {

		this.monthlyPayments = DBPaymentActions.getAllMonthlyPaymentsToGroup(groupID);

	}

}
