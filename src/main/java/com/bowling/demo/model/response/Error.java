package com.bowling.demo.model.response;

public class Error {
	private String message;
	
	public Error() {}

	public Error(String message) {
		if(message == null) this.message = message;
		else this.message = "error";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
