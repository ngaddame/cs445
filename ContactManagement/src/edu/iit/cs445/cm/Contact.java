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
		setName(name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
		setDob(dob);
		setNote(note);
		setFax(fax);
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
}
