package com.wipro.fhir.r4.utils.redis;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public class RedisSessionException extends FHIRException {
	public RedisSessionException(String message, Throwable cause) {
		super(message, cause);
	}

	public RedisSessionException(String message) {
		super(message);
	}
}
