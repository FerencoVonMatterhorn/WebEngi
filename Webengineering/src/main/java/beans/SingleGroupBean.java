package main.java.beans;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SingleGroupBean {

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String description;

	@Setter
	private List<String> users;

	public String getUsers() {
		StringBuilder builder = new StringBuilder();

		for (String string : users) {
			builder.append(string + ", ");
		}
		builder.delete(builder.length() - 3, builder.length() - 1);
		return builder.toString();
	}

}
