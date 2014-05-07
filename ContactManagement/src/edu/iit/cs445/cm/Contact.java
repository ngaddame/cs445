package edu.iit.cs445.cm;

import java.util.Date;


public class Contact  {
	Integer contactId;
	Name name;
	Address address;
	String phone;
	String fax;
	String email;
	Date dob;
	String note;
	public Contact(Name name, Address address, String phone, String fax,
			String email, Date dob, String note) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.dob = dob;
		this.note = note;
	}
	public Contact() {
		super();
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String toString() {
		return "ContactId: "+contactId+" Name: "+name.firstName+" "+name.lastName+" Email: "+email+" Phone: "+phone+" Date of birth: "+dob+" Note: "+note;
	}
}
