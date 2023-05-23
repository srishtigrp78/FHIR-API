package com.wipro.fhir.r4.utils.km;

public interface KMService {
	String getDocumentRoot();

	String createDocument(String documentPath, String filepath);
}
