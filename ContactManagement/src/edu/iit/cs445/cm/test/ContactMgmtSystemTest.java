package edu.iit.cs445.cm.test;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.ContactMgmtSystem;
import edu.iit.cs445.cm.XMLProcessor;
import edu.iit.cs445.cm.util.DateUtil;

public class ContactMgmtSystemTest extends TestCase {
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
	
	public void testViewContact() {
		ContactMgmtSystem.main(new String[] {"view","--contactid", "1"});
	}
	
	public void testAdd() {
		ContactMgmtSystem.main(new String[] {"add","--prefix","Ms","--firstname","srihari","--middlename","tarani","--lastname","Gaddameedi","--city","chicago","--state","illinois","--zip","60616","--country","USA","--phone","31434556","--fax","688997544","--email","uuus@ssd.com","--dob","4/14/1992","--note","asdgjkbjk","--pobox","456","--suffix","Sr.","--street","1234","Main","st."});
	}
	
	
	
	public void testLoad() {
		ContactMgmtSystem.main(new String[] {"load","--filename", fileName});
	}
	
	public void testSearch() {
		ContactMgmtSystem.main(new String[] {"search","--searchkey", "Gaddameedi"});
	}
	
	public void testEdit() {
		ContactMgmtSystem.main(new String[] {"edit","--contactid","1","--prefix","Ms","--firstname","srihari","--middlename","tarani","--lastname","Gaddameedi","--city","chicago","--state","illinois","--zip","60616","--country","USA","--phone","31434556","--fax","688997544","--email","uuus@ssd.com","--dob","4/14/1992","--note","asdgjkbjk","--pobox","456","--suffix","Sr.","--street","1234","Main","st."});
	}
	
	public void testDelete() {
		ContactMgmtSystem.main(new String[] {"delete","--contactid", "1"});
	}
	public void testListAll() {
		ContactMgmtSystem.main(new String[] {"listall"});
	}

}
