package io.pivotal.literx.domain;

import java.util.Objects;

public class User {
	public static final User SKYLER = new User("swhite", "Skyler", "White");
	public static final User JESSE = new User("jpinkman", "Jesse", "Pinkman");
	public static final User WALTER = new User("wwhite", "Walter", "White");
	public static final User SAUL = new User("sgoodman", "Saul", "Goodman");

	private String username;
	private String firstname;
	private String lastname;

	public User(String username, String firstname, String lastname) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(username, user.username) &&
			Objects.equals(firstname, user.firstname) &&
			Objects.equals(lastname, user.lastname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, firstname, lastname);
	}
}
