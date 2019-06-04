package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentOverviewBean {

	private List<Integer> test = new ArrayList<>();
	private int pageSize;
	private int listSize;

	public PaymentOverviewBean() {
		for (int i = 0; i < 15; i++) {
			test.add(i);
		}
		pageSize = test.size() / 5;
		listSize = test.size();
	}

}
