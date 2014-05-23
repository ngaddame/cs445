package edu.iit.cs445.cm;

import java.util.Date;
import java.util.List;

import edu.iit.cs445.cm.util.DateUtil;



public class ContactMgmtSystem {
	XMLProcessor processor;
	public ContactMgmtSystem() {
		processor=new XMLProcessor();
	}
	
	
	public static void main(String[] args) {
		if(args.length>0) {
			try {
				ContactMgmtSystem cms=new ContactMgmtSystem();
			    String command = args[0];
			    if("search".equals(command)) {
			    	cms.search(args);
			    }
			    else if("add".equals(command)) {
			    	cms.add(args);
			    }
			    else if("delete".equals(command)) {
			    	cms.delete(args);
			    }
			    else if("listall".equals(command)) {
			    	cms.listall(args);
			    }
			    else if("load".equals(command)) {
			    	cms.load(args);
			    }
			    else if("edit".equals(command)) {
			    	cms.edit(args);
			    }
			    else if("view".equals(command)) {
			    	cms.view(args);
			    }
			    else {
			    	System.out.println("ERROR: Invalid Command!");
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Please enter a command.");
		}
	}	


	private void load(String[] args) {
		//this method expects only 2 arguments. First argument is command name i.e load and the second argument is file name.
		//if arguments count is less than 2, return and display error message.
		if(args.length<3) {
			System.out.println("*** Invalid Command: *** ");
			System.out.println("   Usage:  "+"load --filename filename");
			//System.exit(0);
		}
		else {
			String fileName=args[2];
			int count=processor.load(fileName);
			System.out.println(count+" contact(s) loaded successfully.");
		}
		
	}
	private void search(String[] args) {
		if(args.length<3) {
			System.out.println("*** Invalid Command: *** ");
			System.out.println("   Usage:  "+"search --searchkey searchkeyvalue");
		}
		else {
			List<Contact> list=processor.search(args[2]);
			int length=list.size();
			if(length!=0)
			{
				printContacts(list);
			}
			else{
				System.out.println("Contact doesn't exist with the specified keyword");
			}
		}
	}


	private void printContacts(List<Contact> list) {
		int birthdayCount=0;
		for(int i=0;i<list.size();i++) {
			Contact contact=list.get(i);
			String name=contact.getName().getFirstName()+" "+contact.getName().getLastName();
			//append spaces for display properly.
			for(int j=name.length();j<25;j++) {
				name=name+" ";				
			}
			System.out.println("ContactId: "+contact.getContactId()+"\tName: "+name+"\tDate Of Birth: "+ DateUtil.convertToString(contact.getDob()));
			if(DateUtil.hasBirthdayInNextSevenDays(contact.getDob())) {
				birthdayCount++;
			}
		}

		System.out.println("\n");
		System.out.println("Total Contacts: "+list.size());
		System.out.println("Number of contacts whose birthday is today or in the next seven days: "+birthdayCount);
	}
	private void add(String[] args) {
		if(args.length<3) {
			System.out.println("*** Invalid Command: ***");
			System.out.println("   Required Fields:  firstname");
			System.out.println("   Optional Fields:  prefix,middlename,lastname,suffix,street,pobox,city,state,zip,country,phone,fax,email,dob,note");
			System.out.println("   Usage:  "+"add --firstname firstname --middlename middlename --lastname <lastname> --sufix <sufix> --street street --pobox pobox --city city --state state --zip zip --country country --phone phone --fax fax --email email --dob dob --note note");
		}
		else
		{
			Contact contact = getContactFromArguments(args);
			processor.add(contact);
			System.out.println("Contact has been added successfully!");
			displayContact(contact);
		}
	}

	private void listall(String[] args) {
		List<Contact> list=processor.listAll();
		System.out.println("*** List of all exisitng contacts ***");
		printContacts(list);
	}
	
	private void edit(String[] args) {
		if(args.length<3) {
			System.out.println("*** Invalid Command: *** ");
			System.out.println("   Usage:  "+"edit --contactid <contactId>");
		}
		else
		{
			Contact newcontact = getContactFromArguments(args);
			
			Contact existingContact=processor.getContactById(newcontact.getContactId());
			if(existingContact==null) {
				System.out.println("Invalid contactid "+newcontact.getContactId());
				return;
			}

			if(existingContact.getAddress()==null) {
				existingContact.setAddress(newcontact.getAddress());
			}
			else {
				if(newcontact.getAddress().getStreet()!=null) {
					existingContact.getAddress().setStreet(newcontact.getAddress().getStreet());
				}
				if(newcontact.getAddress().getPobox()!=null) {
					existingContact.getAddress().setPobox(newcontact.getAddress().getPobox());
				}
				if(newcontact.getAddress().getCity()!=null) {
					existingContact.getAddress().setCity(newcontact.getAddress().getCity());
				}
				if(newcontact.getAddress().getState()!=null) {
					existingContact.getAddress().setState(newcontact.getAddress().getState());
				}
				if(newcontact.getAddress().getCountry()!=null) {
					existingContact.getAddress().setCountry(newcontact.getAddress().getCountry());
				}
				if(newcontact.getAddress().getZip()!=null) {
					existingContact.getAddress().setZip(newcontact.getAddress().getZip());
				}
			}
			
			if(newcontact.getDob()!=null) {
				existingContact.setDob(newcontact.getDob());
			}

			if(newcontact.getEmail()!=null) {
				existingContact.setEmail(newcontact.getEmail());
			}
			
			if(newcontact.getPhone()!=null) {
				existingContact.setPhone(newcontact.getPhone());
			}
			
			if(newcontact.getFax()!=null) {
				existingContact.setFax(newcontact.getFax());
			}
			
			if(newcontact.getNote()!=null) {
				existingContact.setNote(newcontact.getNote());
			}
			
			//if name in existing contact is null, set Name from new contact.
			if(existingContact.getName()==null) {
				existingContact.setName(newcontact.getName());
			}
			else {
				if(newcontact.getName().getPrefix()!=null) {
					existingContact.getName().setPrefix(newcontact.getName().getPrefix());
				}
				if(newcontact.getName().getFirstName()!=null) {
					existingContact.getName().setFirstName(newcontact.getName().getFirstName());
				}
				if(newcontact.getName().getMiddleName()!=null) {
					existingContact.getName().setMiddleName(newcontact.getName().getMiddleName());
				}
				if(newcontact.getName().getLastName()!=null) {
					existingContact.getName().setLastName(newcontact.getName().getLastName());
				}
				if(newcontact.getName().getSufix()!=null) {
					existingContact.getName().setSufix(newcontact.getName().getSufix());
				}
			}
			
			processor.edit(existingContact);
			System.out.println("Contact "+existingContact.getContactId()+" has been updated scussfully.");
			displayContact(existingContact);
		}
	}
		
	private void delete(String[] args) {
		if(args.length<3 || !args[1].equals("--contactid")) {
			System.out.println("*** Invalid Command: *** ");
			System.out.println("   Usage:  "+"delete --contactid <contactId>");
		}
		else
		{
			int contactId=Integer.parseInt(args[2]);
			int deletedcontact=processor.delete(contactId);
			if(deletedcontact==1) {
				System.out.println("Contact "+contactId+" has been deleted sucessfully.");	
			}
			else {
				System.out.println("Invalid contactid.");	
			}
		}
		
	}

	private void view(String[] args) {
		if(args.length<3 || !args[1].equals("--contactid")) {
			System.out.println("*** Invalid Command: *** ");
			System.out.println("   Usage:  "+"view --contactid <contactId>");
		}
		else {
			Contact contact=processor.getContactById(Integer.parseInt(args[2]));
			if(contact!=null) {
				displayContact(contact);
			}
			else {
				System.out.println("Contact not found.");
			}
		}
	}


	private void displayContact(Contact contact) {
		//TODO check nulls for all fields and display empty if it is null.
		System.out.println("********  CONTACT INFO *********");
		System.out.println("ContactId: "+contact.getContactId());
		System.out.println("Prefix: "+contact.getName().getPrefix());
		System.out.println("FirstName: "+contact.getName().getFirstName());
		System.out.println("MiddleName: "+(contact.getName().getMiddleName()==null?"":contact.getName().getMiddleName()));
		System.out.println("LastName: "+contact.getName().getLastName());
		System.out.println("Suffix: "+contact.getName().getSufix());
		System.out.println("street:"+contact.getAddress().getStreet());
		System.out.println("pobox:"+contact.getAddress().getPobox());
		System.out.println("city:"+contact.getAddress().getCity());
		System.out.println("state:"+contact.getAddress().getState());
		System.out.println("zip:"+contact.getAddress().getZip());
		System.out.println("country:"+contact.getAddress().getCountry());
		System.out.println("phone:"+contact.getPhone());
		System.out.println("fax:"+contact.getFax());
		System.out.println("email:"+contact.getEmail());
		System.out.println("dob:"+(contact.getDob()==null?"":DateUtil.convertToString(contact.getDob())));
		System.out.println("note:"+contact.getNote());
		System.out.println("********************************");
	}
	
	/**
	 * Builds a Contact object from command line arguments.
	 * @param args
	 * @return
	 */
	private Contact getContactFromArguments(String[] args) {
		String firstname=null;
		String prefix=null;
		String middlename=null;
		String lastname=null;
		String suffix=null;
		String street=null;
		String pobox=null;
		String city=null;
		String state=null;
		String zip=null;
		String country=null;
		String phone=null;
		String fax=null;
		String email=null;
		Date dob=null;
		String note=null;
		int contactId=0;
		for(int i=1;i<args.length;i++) {
			String argument=args[i];
			if(argument!=null && argument.startsWith("--")) {
				if(argument.equals("--contactid")) {
					if(args[i+1]!=null) {
						contactId=Integer.parseInt(args[i+1]);
					}
				}
				if(argument.equals("--firstname")) {
					firstname=args[i+1];
				}
				if(argument.equals("--prefix")){
					prefix=args[i+1];
				}
				if(argument.equals("--middlename")){
					middlename=args[i+1];
				}
				if(argument.equals("--lastname"))
				{
					lastname=args[i+1];
				}
				if(argument.equals("--suffix"))
				{
					suffix=args[i+1];
				}
				if(argument.equals("--street"))
				{
					street=args[i+1];
				}
				if(argument.equals("--pobox"))
				{
					pobox=args[i+1];
				}
				if(argument.equals("--city"))
				{
					city=args[i+1];
				}
				if(argument.equals("--state"))
				{
					state=args[i+1];
				}
				if(argument.equals("--zip"))
				{
					zip=args[i+1];
				}
				if(argument.equals("--country"))
				{
					country=args[i+1];
				}
				if(argument.equals("--phone"))
				{
					phone=args[i+1];
				}
				if(argument.equals("--fax"))
				{
					fax=args[i+1];
				}
				if(argument.equals("--email"))
				{
					email=args[i+1];
				}
				if(argument.equals("--dob"))
				{
					if(args[i+1]!=null) {
						dob=DateUtil.convertToDate(args[i+1]);
					}
				}
				if(argument.equals("--note"))
				{
					note=args[i+1];
				}
				
			}
		}
		Address address=new Address(street, pobox, city, state, zip, country);
		Name name=new Name(prefix, firstname, middlename, lastname, suffix);
		Contact contact=new Contact(name, address, phone, fax, email, dob, note);
		contact.setContactId(contactId);
		return contact;
	}

}
