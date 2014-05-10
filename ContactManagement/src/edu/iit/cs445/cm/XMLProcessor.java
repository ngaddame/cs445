package edu.iit.cs445.cm;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.iit.cs445.cm.util.DateUtil;


public class XMLProcessor {
	
		private static final String masterXMLFile="cms_master.xml";
		public XMLProcessor() {
			super();
		}

	public int getContactIdCurrentVal() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Contact getContactById(int contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delete(int contactId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int load(String fileName) {
		
		try {
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("contact");
			for (int temp = 0; temp < nList.getLength(); temp++) {		 
				Node nNode = nList.item(temp);		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {		 
					Contact contact = getContact(nNode);
					add(contact);
				}
			}
			return nList.getLength();
		} catch (Exception e) {
	    	e.printStackTrace();
	    	return 0;
	    }

	}
	private Contact getContact(Node nNode) {
		Element eElement = (Element) nNode;
		
		String prefix,firstName,middleName,lastName,suffix;prefix=firstName=middleName=lastName=suffix=null;
		String email,phone,fax,note,dob;email=phone=fax=note=dob=null;
		String pobox,street,city,state,zip,country;pobox=street=city=state=zip=country=null;		
		
		if(eElement.getElementsByTagName("prefix").item(0)!=null)
			prefix=eElement.getElementsByTagName("prefix").item(0).getTextContent();
		if(eElement.getElementsByTagName("firstname").item(0)!=null)
			firstName=eElement.getElementsByTagName("firstname").item(0).getTextContent();
		if(eElement.getElementsByTagName("middlename").item(0)!=null)
			middleName= eElement.getElementsByTagName("middlename").item(0).getTextContent();
		if(eElement.getElementsByTagName("lastname").item(0)!=null)
			lastName= eElement.getElementsByTagName("lastname").item(0).getTextContent();
		if(eElement.getElementsByTagName("suffix").item(0)!=null)
			suffix= eElement.getElementsByTagName("suffix").item(0).getTextContent();
		
		if(eElement.getElementsByTagName("email").item(0)!=null)
			email=eElement.getElementsByTagName("email").item(0).getTextContent();
		if(eElement.getElementsByTagName("phone").item(0)!=null)
			phone= eElement.getElementsByTagName("phone").item(0).getTextContent();
		if(eElement.getElementsByTagName("fax").item(0)!=null)
			fax= eElement.getElementsByTagName("fax").item(0).getTextContent();
		if(eElement.getElementsByTagName("note").item(0)!=null)
			note= eElement.getElementsByTagName("note").item(0).getTextContent();
		if(eElement.getElementsByTagName("dob").item(0)!=null)
			dob= eElement.getElementsByTagName("dob").item(0).getTextContent();
		
		if(eElement.getElementsByTagName("pobox").item(0)!=null)
			pobox= eElement.getElementsByTagName("pobox").item(0).getTextContent();
		if(eElement.getElementsByTagName("street").item(0)!=null)
			street= eElement.getElementsByTagName("street").item(0).getTextContent();
		if(eElement.getElementsByTagName("city").item(0)!=null)
			city= eElement.getElementsByTagName("city").item(0).getTextContent();
		if(eElement.getElementsByTagName("state").item(0)!=null)
			state= eElement.getElementsByTagName("state").item(0).getTextContent();
		if(eElement.getElementsByTagName("zip").item(0)!=null)
			zip= eElement.getElementsByTagName("zip").item(0).getTextContent();
		if(eElement.getElementsByTagName("country").item(0)!=null)
			country= eElement.getElementsByTagName("country").item(0).getTextContent();
		
		Name name=new Name(prefix, firstName, middleName, lastName, suffix);
		Address address=new Address(street, pobox, city, state, zip, country);
		Contact contact=new Contact(name, address, phone, fax, email, DateUtil.convertToDate(dob), note);
		
		Node id = eElement.getElementsByTagName("contactId").item(0);
		if(id!=null) {
			contact.setContactId(Integer.parseInt(id.getTextContent()));
		}
		return contact;
	}

	public List<Contact> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> search(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void edit(Contact contact) {
		// TODO Auto-generated method stub
		
	}


}
