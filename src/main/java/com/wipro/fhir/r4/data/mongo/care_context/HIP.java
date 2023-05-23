package com.wipro.fhir.r4.data.mongo.care_context;

public class HIP {

	String name;
	String id;
	
	public String getName() {
		return name;
	}
	public HIP(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
