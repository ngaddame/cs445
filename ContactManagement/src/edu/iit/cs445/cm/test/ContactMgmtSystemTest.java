package edu.iit.cs445.cm.test;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.ContactMgmtSystem;
import edu.iit.cs445.cm.XMLProcessor;

public class ContactMgmtSystemTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	XMLProcessor p;
	String fileName;
	Contact contact=null;
	int contactId=0;
	protected void setUp()  throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		p=new XMLProcessor();
		fileName="contacts_for_unittest.xml";
		contactId=p.getContactIdCurrentVal();
		p.load(fileName);		
		contact=p.getContactById(contactId);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		p.delete(contactId);
	     System.setOut(null);
	     System.setErr(null);
	}
	
	public void testViewContact() {
		int contactId=p.getContactIdCurrentVal();
		ContactMgmtSystem.main(new String[] {"view","--contactid", String.valueOf(contactId-1)});
		String a=outContent.toString();
		assertTrue(outContent.toString().contains("ContactId: "+String.valueOf(contactId-1)));

	}
	
	public void testAdd() {
		ContactMgmtSystem.main(new String[] {"add","--prefix","Ms","--firstname","srihari","--middlename","tarani","--lastname","Gaddameedi","--city","chicago","--state","illinois","--zip","60616","--country","USA","--phone","31434556","--fax","688997544","--email","uuus@ssd.com","--dob","4/14/1992","--note","asdgjkbjk","--pobox","456","--suffix","Sr.","--street","1234","Main","st."});
		assertTrue(outContent.toString().startsWith("Contact has been added successfully"));
	}
	
	
	
	public void testLoad() {
		ContactMgmtSystem.main(new String[] {"load","--filename", fileName});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("1 contact(s) loaded successfully."));

	}
	
	public void testSearch() {
		ContactMgmtSystem.main(new String[] {"search","--searchkey", "Gaddameedi"});
		assertTrue(outContent.toString().contains("Gaddameedi"));
	}
	public void testEdit() {
		int contactId=p.getContactIdCurrentVal();
		ContactMgmtSystem.main(new String[] {"edit","--contactid",String.valueOf(contactId-1),"--prefix","Ms","--firstname","srihari","--middlename","tarani","--lastname","Gaddameedi","--city","chicago","--state","illinois","--zip","60616","--country","USA","--phone","31434556","--fax","688997544","--email","uuus@ssd.com","--dob","4/14/1992","--note","asdgjkbjk","--pobox","456","--suffix","Sr.","--street","1234","Main","st."});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("Contact "+String.valueOf(contactId-1)+" has been updated scussfully."));
	}
	
	public void testDelete() {
		int contactId=p.getContactIdCurrentVal();
		ContactMgmtSystem.main(new String[] {"delete","--contactid", String.valueOf(contactId-1)});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("Contact "+String.valueOf(contactId-1)+" has been deleted sucessfully."));
	}
	public void testListAll() {
		ContactMgmtSystem.main(new String[] {"listall"});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("*** List of all exisitng contacts ***"));
	}
	
	public void testViewContactInvalidContactId() {
		ContactMgmtSystem.main(new String[] {"view","--contactid", "-1"});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("Contact not found."));
	}
	
	public void testViewContactInvalidCommand() {
		ContactMgmtSystem.main(new String[] {"view"});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("*** Invalid Command: ***"));
	}
	
	public void testAddInvalid() {
		ContactMgmtSystem.main(new String[] {"add",null});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("*** Invalid Command: ***"));
	}
	 
	public void testLoadInvalid() {
		ContactMgmtSystem.main(new String[] {"load","--filename"});
		String a=outContent.toString();
		assertTrue(outContent.toString().startsWith("*** Invalid Command: ***"));
	}
	
	public void testSearchInvalidContactId() {
		ContactMgmtSystem.main(new String[] {"search","--searchkey","X7D5Fj%"});
		assertTrue(outContent.toString().startsWith("Contact doesn't exist with the specified keyword"));
	}
	public void testSearchInvalidCommand() {
		ContactMgmtSystem.main(new String[] {"search","--searchkey"});
		assertTrue(outContent.toString().startsWith("*** Invalid Command: ***"));
	}
	public void testEditInvalidContactid() {
		ContactMgmtSystem.main(new String[] {"edit","--contactid","-1"});
		assertTrue(outContent.toString().startsWith("Invalid contactid -1"));
	}
	public void testEditInvalidCommand() {
		ContactMgmtSystem.main(new String[] {"edit","--contactid"});
		assertTrue(outContent.toString().startsWith("*** Invalid Command: ***"));
	}
	public void testDeleteInvalidContactId() {
		ContactMgmtSystem.main(new String[] {"delete","--contactid","-1"});
		assertTrue(outContent.toString().startsWith("Invalid contactid."));
	}
	public void testDeleteInvalidComamnd() {
		ContactMgmtSystem.main(new String[] {"delete","--contactid"});
		assertTrue(outContent.toString().startsWith("*** Invalid Command: ***"));
	}
	public void testInvalidCommand() {
		ContactMgmtSystem.main(new String[] {"invalid"});
		assertTrue(outContent.toString().startsWith("ERROR: Invalid Command!"));
	}
	public void testNoCommand() {
		ContactMgmtSystem.main(new String[] {});
		assertTrue(outContent.toString().startsWith("Please enter a command."));
	}
}
