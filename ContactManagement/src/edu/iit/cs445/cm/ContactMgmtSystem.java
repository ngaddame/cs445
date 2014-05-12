package edu.iit.cs445.cm;
public class ContactMgmtSystem {
	public ContactMgmtSystem() {
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
}
