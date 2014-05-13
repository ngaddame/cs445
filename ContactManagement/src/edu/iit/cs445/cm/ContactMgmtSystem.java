package edu.iit.cs445.cm;

import java.util.Date;

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
			    else if("save".equals(command)) {
			    	cms.save(args);
			    }
			    else if("view".equals(command)) {
			    	cms.view(args);
			    }
			    else {
			    	System.out.println("ERROR: Invalid Command!");
			    	System.exit(1);
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Please enter a command.");
		}
	}	


	private void save(String[] args) {
		System.out.println("*** Save ***");
	}
	
	private void load(String[] args) {
	
		//this method expects only 2 arguments. First argument is command name i.e load and the second argument is file name.
				//if arguments count is less than 2, return and display error message.
				if(args.length<2) {
					System.out.println("** Invalid Command: *** "+"Two arguments required for load command.");
					System.out.println("   Usage:  "+"cms load filename");
					System.exit(1);
				}
				
				String fileName=args[1];
				int count=processor.load(fileName);
				System.out.println(count+" contact(s) loaded successfully.");
	}

	private void search(String[] args) {
		System.out.println("*** Search ***");
	}


	private void add(String[] args) {
		System.out.println("*** Add ***");
		if(args.length<2) {
			System.out.println("** Invalid Command: *** "+"Two arguments required for load command.");
			System.out.println("   Required Fields:  firstname");
			System.out.println("   Optional Fields:  prefix,middlename,lastname,suffix,street,pobox,city,state,zip,country,phone,fax,email,dob,note");
			System.out.println("   Usage:  "+"cms add firstname");
			System.exit(1);
		}
		else
		{
			Contact contact = getContactFromArguments(args);
			processor.add(contact);
			System.out.println("Contact has been added successfully!");
			displayContact(contact);
		}
		
	}

	private void delete(String[] args) {
		System.out.println("*** Delete ***");
	}

	private void edit(String[] args) {
		System.out.println("*** Edit ***");
	}
		
	private void view(String[] args) {
		System.out.println("*** View ***");
	}
	
	private void listall(String[] args) {
		System.out.println("*** List All ***");
	}
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
				else if(argument.equals("--firstname")) {
					firstname=args[i+1];
				}
				else if(argument.equals("--prefix")){
					prefix=args[i+1];
				}
				else if(argument.equals("--middlename")){
					middlename=args[i+1];
				}
				else if(argument.equals("--lastname"))
				{
					lastname=args[i+1];
				}
				else if(argument.equals("--suffix"))
				{
					suffix=args[i+1];
				}
				else if(argument.equals("--street"))
				{
					street=args[i+1];
				}
				else if(argument.equals("--pobox"))
				{
					pobox=args[i+1];
				}
				else if(argument.equals("--city"))
				{
					city=args[i+1];
				}
				else if(argument.equals("--state"))
				{
					state=args[i+1];
				}
				else if(argument.equals("--zip"))
				{
					zip=args[i+1];
				}
				else if(argument.equals("--country"))
				{
					country=args[i+1];
				}
				else if(argument.equals("--phone"))
				{
					phone=args[i+1];
				}
				else if(argument.equals("--fax"))
				{
					fax=args[i+1];
				}
				else if(argument.equals("--email"))
				{
					email=args[i+1];
				}
				else if(argument.equals("--dob"))
				{
					if(args[i+1]!=null) {
						dob=DateUtil.convertToDate(args[i+1]);
					}
				}
				else if(argument.equals("--note"))
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
	private void displayContact(Contact contact) {
		System.out.println("********  CONTACT INFO *********");
		System.out.println("ContactId: "+contact.getContactId());
		System.out.println("Prefix: "+contact.getName().getPrefix());
		System.out.println("FirstName: "+contact.getName().getFirstName());
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
}
