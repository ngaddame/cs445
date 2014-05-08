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
		System.out.println("*** Load ***");
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
