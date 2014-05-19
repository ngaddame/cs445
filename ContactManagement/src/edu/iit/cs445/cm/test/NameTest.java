package edu.iit.cs445.cm.test;

import edu.iit.cs445.cm.Name;
import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.XMLProcessor;
import junit.framework.TestCase;

public class NameTest extends TestCase{
	String fileName;
	XMLProcessor p;
	Contact contact=null;
	Name name=null;
	int contactId=0;
	protected void setUp()  throws Exception {
	p=new XMLProcessor();
	fileName="contacts_for_unittest.xml";
	contactId=p.getContactIdCurrentVal();
	p.load(fileName);		
	contact=p.getContactById(contactId);
	name =contact.getName();
		
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
	
	protected void tearDown() throws Exception {
		super.tearDown();
		p.delete(contactId);
	}
	public void testPrefix()
	{
		assertEquals("Mr.",name.getPrefix());
	}
	public void testFirstName()
	{
		assertEquals("Namrata",name.getFirstName());
	}
	public void testMiddleName()
	{
		assertEquals("",name.getMiddleName());
	}
	public void testLastName()
	{
		assertEquals("Gaddameedi",name.getLastName());
	}
	public void testSufix()
	{
		assertEquals("Jr.",name.getSufix());
	}
	
}
