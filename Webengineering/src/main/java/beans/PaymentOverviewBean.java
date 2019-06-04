package main.java.beans;

import java.util.ArrayList;
import java.util.List;

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

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public List<Integer> getTest() {
		return test;
	}

	public void setTest(List<Integer> test) {
		this.test = test;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
