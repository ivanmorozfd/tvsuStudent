package ru.math.tversu.studentapp.model.user;

public enum UserRole {
	ADMIN("admin"),
	TEACHER("teacher"),
	STUDENT("student");

	private final String text;

	UserRole(String text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return text;
	}
}
