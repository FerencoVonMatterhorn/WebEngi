package main.java.beans;

import java.util.List;

public class SingleGroupBean {

	private String name;
	private String description;
	private List<String> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsers() {
		StringBuilder builder = new StringBuilder();

		for (String string : users) {
			builder.append(string + ", ");
		}
		builder.delete(builder.length() - 3, builder.length() - 1);
		return builder.toString();
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

}
