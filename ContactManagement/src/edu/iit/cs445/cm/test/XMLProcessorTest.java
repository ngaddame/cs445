package edu.iit.cs445.cm.test;

import java.util.List;

import edu.iit.cs445.cm.Contact;
import edu.iit.cs445.cm.XMLProcessor;
import junit.framework.TestCase;

public class XMLProcessorTest extends TestCase {
	XMLProcessor p;
	String fileName;
	int contactId=0;
	
	protected void setUp()  throws Exception {
		p=new XMLProcessor();
		contactId=p.getContactIdCurrentVal();
		fileName="contacts_for_unittest.xml";
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		p.delete(contactId);
	}

	public void testLoad() {		
		int size=p.load(fileName);
		assertEquals(1,size);
	}
	
	
	public void testEdit() {
		p.load(fileName);
		String note="modified note in contact";
		Contact contact=p.getContactById(contactId);
		contact.setNote(note);
		p.edit(contact);
		contact=p.getContactById(contactId);
		assertEquals(note, contact.getNote());
	}
	
	public void testListAll() {		
		p.load(fileName);
		List<Contact> contacts=p.listAll();
		assertEquals(1,contacts.size());
	}
	
	public void testSearchValidContact() {		
		p.load(fileName);
		List<Contact> contacts=p.search("Gaddameedi");
		assertEquals(1,contacts.size());
	}
	
	public void testSearchInvalidContact() {		
		p.load(fileName);
		List<Contact> contacts=p.search("X4N8%H&D$K");
		assertEquals(0,contacts.size());
	}
	
	public void testDeleteSuccess() {
		p.load(fileName);
		int size=p.delete(contactId);
		assertEquals(1,size);
	}
	
	public void testDeleteFail() {
		int size=p.delete(9999);
		assertEquals(0,size);
	}
}
