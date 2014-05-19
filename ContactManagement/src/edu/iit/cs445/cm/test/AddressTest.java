package edu.iit.cs445.cm.test;

import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.Address;
import edu.iit.cs445.cm.XMLProcessor;
import junit.framework.TestCase;

public class AddressTest extends TestCase {
	XMLProcessor p;
	String fileName;
	Contact contact=null;
	Address address=null;
	int contactId=0;
	protected void setUp()  throws Exception {
		p=new XMLProcessor();
		fileName="contacts_for_unittest.xml";
		contactId=p.getContactIdCurrentVal();
		p.load(fileName);		
		contact=p.getContactById(contactId);
		address=contact.getAddress();
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		p.delete(contactId);
	}
	/*
	<name>
	<prefix>Mr.</prefix>
	<firstName>Namrata</firstName>
	<middleName></middleName>
	<lastName>Gaddameedi</lastName>
	<suffix>Jr.</suffix>
</name>
<phone>3142786242</phone>
<fax></fax>
<email>g.namrata92@gmail.com</email>
<note>This is my favourite conbtact</note>
<dob>04/14/2000</dob>
<address>
	<street>424 Clay St</street>
	<pobox>703</pobox>
	<city>San Francisco</city>
	<state>California</state>
	<zip>94111</zip>
	<country>USA</country>
</address>
*/
	public void testStreet() {		
		assertEquals("424 Clay St",address.getStreet());
	}
	public void testPobox(){
		assertEquals("703",address.getPobox());
	}
	public void testCity(){
		assertEquals("San Francisco",address.getCity());
	}
	public void testState(){
		assertEquals("California",address.getState());
	}
	public void testZip(){
		assertEquals("94111",address.getZip());
	}
	public void testCountry(){
		assertEquals("USA",address.getCountry());
	}

}
