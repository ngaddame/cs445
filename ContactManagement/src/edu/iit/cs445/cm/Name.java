package edu.iit.cs445.cm;

public class Name {
	String firstName;
	String middleName;
	String lastName;
	String prefix;
	String sufix;
	public Name(String prefix,String firstName, String middleName, String lastName, String sufix) {
		super();
		setPrefix(prefix);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setSufix(sufix);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSufix() {
		return sufix;
	}
	public void setSufix(String sufix) {
		this.sufix = sufix;
	}



}
