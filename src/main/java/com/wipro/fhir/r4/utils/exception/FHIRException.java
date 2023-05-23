package com.wipro.fhir.r4.utils.exception;

public class FHIRException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = null;

	public FHIRException(String message, Throwable cause) {
		super(message);
		this.message = message;
		super.setStackTrace(cause.getStackTrace());
	}

	public FHIRException(String message) {
		super(message);
		this.message = message;
	}

	public String toString() {
		return this.message;
	}

	public String getMessage() {
		return this.message;
	}
}
