package com.customexception;

public class InvalidChoiceException extends RuntimeException {
	private String message;

	public InvalidChoiceException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
