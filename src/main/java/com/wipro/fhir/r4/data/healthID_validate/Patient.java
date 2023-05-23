package com.wipro.fhir.r4.data.healthID_validate;

public class Patient {
	String Id;
	String Name;
	String Gender;
	String YearOfBirth;
	Address Address;

      public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getYearOfBirth() {
		return YearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		YearOfBirth = yearOfBirth;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	
}
