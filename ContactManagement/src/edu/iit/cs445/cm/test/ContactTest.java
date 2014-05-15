package edu.iit.cs445.cm.test;

import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.XMLProcessor;
import edu.iit.cs445.cm.util.DateUtil;
import junit.framework.TestCase;

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
		
		assertEquals("g.namrata92@gmail.com",contact.getEmail());
	}

	public void testFax() {
		//TODO
		assertEquals("",contact.getFax());
	}
	
	public void testDOB() {	
		//TODO
		assertEquals("04/14/2000",DateUtil.convertToString(contact.getDob()));
	}
	
	public void testNote() {
		//TODO
		assertEquals("This is my favourite conbtact",contact.getNote());
	}
	public void testPhone() {
		//TODO
		assertEquals("3142786242",contact.getPhone());
	}

	public void testName() {	
		//TODO
		assertEquals("Mr.",contact.getName().getPrefix());
		assertEquals("Namrata",contact.getName().getFirstName());
		assertEquals("",contact.getName().getMiddleName());
		assertEquals("Gaddameedi",contact.getName().getLastName());
		assertEquals("Jr.",contact.getName().getSufix());
	}
}
