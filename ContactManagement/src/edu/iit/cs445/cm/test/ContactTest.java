package edu.iit.cs445.cm.test;

import junit.framework.TestCase;
import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.XMLProcessor;

public class ContactTest extends TestCase {
	XMLProcessor p;
	String fileName;
	Contact contact=null;
	int contactId=0;
	protected void setUp()  throws Exception {
		p=new XMLProcessor();
		fileName="contacts_for_unittest.xml";
		contactId=p.getContactIdCurrentVal();
		p.load(fileName);		
		contact=p.getContactById(contactId);
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
	public void testAddress() {		
		assertEquals("424 Clay St",contact.getAddress().getStreet());
		assertEquals("703",contact.getAddress().getPobox());
		assertEquals("San Francisco",contact.getAddress().getCity());
		assertEquals("California",contact.getAddress().getState());
		assertEquals("94111",contact.getAddress().getZip());
		assertEquals("USA",contact.getAddress().getCountry());
	}
	
	public void testEmail() {	
		//TODO
		assertEquals("tobodone","TODO");
	}

	public void testFax() {
		//TODO
		assertEquals("tobodone","TODO");
	}
	
	public void testDOB() {	
		//TODO
		assertEquals("tobodone","TODO");
	}
	
	public void testNote() {
		//TODO
		assertEquals("tobodone","TODO");
	}

	public void testName() {	
		//TODO
		assertEquals("tobodone","TODO");
	}
}
