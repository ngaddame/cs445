package edu.iit.cs445.cm;

public class Address {
	String street;
	String pobox;
	String city;
	String state;	
	String zip;
	String country;
	public Address(String street, String pobox, String city, String state, String zip,String country) {
		super();
		this.street = street;
		this.pobox = pobox;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPobox() {
		return pobox;
	}
	public void setPobox(String pobox) {
		this.pobox = pobox;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
}
