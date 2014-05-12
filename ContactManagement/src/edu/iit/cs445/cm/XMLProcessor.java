package edu.iit.cs445.cm;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
		int status=0;
		try {
			//step1: read contacts from master file.
			File fXmlFile = new File(masterXMLFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList contactElements = doc.getElementsByTagName("contact");
			for (int i = 0; i < contactElements.getLength(); i++) {		 
				Node contactNode = contactElements.item(i);		 
		 		if (contactNode.getNodeType() == Node.ELEMENT_NODE) {		 
					Element eElement = (Element) contactNode;
					String cId=eElement.getElementsByTagName("contactId").item(0).getTextContent();
					if(cId!=null && Integer.parseInt(cId)==contactId) {
						contactNode.getParentNode().removeChild(contactNode);
						status=1;
					}
				}
			}
			writeToMaster(doc);
		} catch (Exception e) {
	    	e.printStackTrace();
	    }
		return status;
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
	public void add(Contact contact) {
		try {
			//get contact id sequence next value value.
			int cId=getcontactIdNextVal();
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(masterXMLFile);
	 
			Node contacts = doc.getElementsByTagName("contacts").item(0);
			Element contactNode = doc.createElement("contact");
			Element contactId = doc.createElement("contactId");
			contactId.appendChild(doc.createTextNode(String.valueOf(cId)));
			contactNode.appendChild(contactId);
			contact.setContactId(cId);
			
			Element email = doc.createElement("email");
			email.appendChild(doc.createTextNode(contact.getEmail()));
			contactNode.appendChild(email);
			
			Element phone = doc.createElement("phone");
			phone.appendChild(doc.createTextNode(contact.getPhone()));
			contactNode.appendChild(phone);

			Element fax = doc.createElement("fax");
			fax.appendChild(doc.createTextNode(contact.getFax()));
			contactNode.appendChild(fax);

			Element dob = doc.createElement("dob");
			dob.appendChild(doc.createTextNode(DateUtil.convertToString(contact.getDob())));
			contactNode.appendChild(dob);
			
			Element note = doc.createElement("note");
			note.appendChild(doc.createTextNode(contact.getNote()));
			contactNode.appendChild(note);
			
			Element name = doc.createElement("name");
			Element prefix = doc.createElement("prefix");
			prefix.appendChild(doc.createTextNode(contact.getName().getPrefix()));
			name.appendChild(prefix);
			
			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode(contact.getName().getFirstName()));
			name.appendChild(firstname);
			
			Element middlename = doc.createElement("middlename");
			middlename.appendChild(doc.createTextNode(contact.getName().getMiddleName()));
			name.appendChild(middlename);
			
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode(contact.getName().getLastName()));
			name.appendChild(lastname);
			
			Element suffix = doc.createElement("suffix");
			suffix.appendChild(doc.createTextNode(contact.getName().getSufix()));
			name.appendChild(suffix);
			
			contactNode.appendChild(name);
			
			Element address = doc.createElement("address");
			Element street = doc.createElement("street");
			street.appendChild(doc.createTextNode(contact.getAddress().getStreet()));
			address.appendChild(street);
			
			Element pobox = doc.createElement("pobox");
			pobox.appendChild(doc.createTextNode(contact.getAddress().getPobox()));
			address.appendChild(pobox);
			
			Element city= doc.createElement("city");
			city.appendChild(doc.createTextNode(contact.getAddress().getCity()));
			address.appendChild(city);
			
			Element state= doc.createElement("state");
			state.appendChild(doc.createTextNode(contact.getAddress().getState()));
			address.appendChild(state);
			
			Element country= doc.createElement("country");
			country.appendChild(doc.createTextNode(contact.getAddress().getCountry()));
			address.appendChild(country);
			
			Element zip= doc.createElement("zip");
			zip.appendChild(doc.createTextNode(contact.getAddress().getZip()));
			address.appendChild(zip);
			contactNode.appendChild(address);

			contacts.appendChild(contactNode);
			writeToMaster(doc);
	   } catch (ParserConfigurationException pce) {
		   pce.printStackTrace();
	   } catch (TransformerException tfe) {
		   tfe.printStackTrace();
	   } catch (IOException ioe) {
		   ioe.printStackTrace();
	   } catch (SAXException sae) {
		   sae.printStackTrace();
	   }
	}
	private int getcontactIdNextVal() {
		int cId=0;
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(masterXMLFile);
			String contactIdNextVal=doc.getElementsByTagName("contactIdSequenceValue").item(0).getTextContent();			
			if(contactIdNextVal!=null) {
				cId=Integer.parseInt(contactIdNextVal);
			}
			Node cIdNextNode = doc.getElementsByTagName("contactIdSequenceValue").item(0);
			cIdNextNode.setTextContent(String.valueOf(cId+1));
			writeToMaster(doc);
	   } catch (ParserConfigurationException pce) {
		   pce.printStackTrace();
	   } catch (TransformerException tfe) {
		   tfe.printStackTrace();
	   } catch (IOException ioe) {
		   ioe.printStackTrace();
	   } catch (SAXException sae) {
		   sae.printStackTrace();
	   }
		return cId;
	}
	
	private void writeToMaster(Document doc)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		// write the content into xml file
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(masterXMLFile));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("Master XML file updated successfully");
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
