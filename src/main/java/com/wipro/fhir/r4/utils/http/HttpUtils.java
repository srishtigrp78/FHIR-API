package com.wipro.fhir.r4.utils.http;

import java.util.HashMap;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtils {
	public static final String AUTHORIZATION = "Authorization";
	private String server;
	// @Autowired
	private RestTemplate rest;
	// @Autowired
	private HttpHeaders headers;
	// @Autowired
	private HttpStatus status;

	// @Autowired(required = true)
	// @Qualifier("hibernateCriteriaBuilder")
	public HttpUtils() {
		if (rest == null) {
			rest = new RestTemplate();
			headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
		}
	}
	// public HttpUtils() {
	// if (rest == null) {
	// rest = new RestTemplate();
	// headers = new HttpHeaders();
	// headers.add("Content-Type", "application/json");
	// }
	// }

	// @Bean
	// public HttpUtils httpUtils() {
	// return new HttpUtils();
	// }

	public String get(String uri) {
		String body;
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		// if (status == HttpStatus.OK){
		body = responseEntity.getBody();
		// }else{
		// responseEntity
		// }
		return body;
	}

	public String getPatientDataFromFeed(String uri, HttpHeaders headers) {
		String body;
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		// if (status == HttpStatus.OK){
		body = responseEntity.getBody();
		// }else{
		// responseEntity
		// }
		return body;
	}

	public String get(String uri, HashMap<String, Object> header) {
		String body;
		HttpHeaders headers = new HttpHeaders();
		if (header.containsKey(headers.AUTHORIZATION)) {
			headers.add(headers.AUTHORIZATION, header.get(headers.AUTHORIZATION).toString());
		}
		if (header.containsKey(headers.CONTENT_TYPE)) {
			headers.add(headers.CONTENT_TYPE, header.get(headers.CONTENT_TYPE).toString());
		} else {
			headers.add("Content-Type", MediaType.APPLICATION_JSON);
		}
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		body = responseEntity.getBody();
		return body;
	}

	public String post(String uri, String json) {
		String body;
		HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
		ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		body = responseEntity.getBody();
		return body;
	}

	public String post(String uri, String data, HashMap<String, Object> header) {
		String body;
		HttpHeaders headers = new HttpHeaders();
		if (header.containsKey(headers.AUTHORIZATION)) {
			headers.add(headers.AUTHORIZATION, header.get(headers.AUTHORIZATION).toString());
		}
		// headers.add("Content-Type", MediaType.APPLICATION_JSON);
		ResponseEntity<String> responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		HttpEntity<String> requestEntity;
		requestEntity = new HttpEntity<String>(data, headers);
		responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		body = responseEntity.getBody();
		return body;
	}

	public ResponseEntity<String> postWithResponseEntity(String uri, String data, HttpHeaders header) {
		// String body;
		ResponseEntity<String> responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		HttpEntity<String> requestEntity;
		requestEntity = new HttpEntity<String>(data, header);
		responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		// body = responseEntity.getBody();
		return responseEntity;
	}

	public ResponseEntity<String> getWithResponseEntity(String uri, HttpHeaders header) {
		// String body;
		ResponseEntity<String> responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		HttpEntity<String> requestEntity = new HttpEntity<String>("", header);
		responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		// body = responseEntity.getBody();
		return responseEntity;
	}

	public ResponseEntity<byte[]> getWithResponseEntityByte(String uri, HttpHeaders header) {
		// String body;
		ResponseEntity<byte[]> responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		HttpEntity<String> requestEntity = new HttpEntity<String>("", header);
		responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, byte[].class);
		setStatus(responseEntity.getStatusCode());
		// body = responseEntity.getBody();
		return responseEntity;
	}

	public String post(String uri, String data, HttpHeaders header) {
		String body;
		ResponseEntity<String> responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		HttpEntity<String> requestEntity;
		requestEntity = new HttpEntity<String>(data, header);
		responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		setStatus(responseEntity.getStatusCode());
		body = responseEntity.getBody();
		return body;
	}

	@Deprecated
	public String postStatusCode(String uri, String data, HttpHeaders header) {
		HttpStatus statusCode;
		// HttpHeaders headers = new HttpHeaders();
//		if (header.containsKey(headers.AUTHORIZATION)) {
//			headers.add(headers.AUTHORIZATION, header.get(headers.AUTHORIZATION).toString());
//		}
		// headers.add("Content-Type", MediaType.APPLICATION_JSON);
		ResponseEntity<String> responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
		HttpEntity<String> requestEntity;
		requestEntity = new HttpEntity<String>(data, header);
		responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		statusCode = responseEntity.getStatusCode();
		return statusCode.toString();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}