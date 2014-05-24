Content in the namrata-gaddameedi-PR-contactmanagement folder:

The src folder in the project folder contains the java code for the project
1.	The edu.iit.cs445.cm folder contains java classes 
2.	The edu.iit.cs445.cm.test folder contains test classes
3.	The edu.iit.cs445.cm.util folder contains DateUtil class
	CMS-uml diagrams.pdf file has uml diagrams, project description and format for commands with the output.
	Memo File describing the statistics ,test coverage ,cyclomatic complexity of the project
Xml files:
	Load.xml file for loading contacts
	cms_master.xml file  contains details about the contacts loaded and added by the user.
	Contacts_for_unittest.xml contains the contact that has to be tested.
	build.xml  used for building and running the project.

Steps for executing the project :

1.	Install git using the command mentioned below command: sudo apt-get install git
2.	clone project from github command: git clone https://github.com/ngaddame/cs445.git
3.	go to cs445/ContactManagement directory command: cd ./cs445/ContactManagement
4.	install java using the below commands command: sudo apt-get install openjdk-7-jre-headless command: sudo apt-get install openjdk-7-jdk
5.	install ant command: sudo apt-get install ant
6.	run ant build to compile and assemple the application code. command: ant build
7.	run unit test. command: ant test
8.	run application. command:

ant -Dargs="load --filename load_contacts.xml"
ant -Dargs="listall" 
ant -Dargs="add --prefix mr. --firstname SAM --middlename MARIA --lastname JOHN --suffix JR. --city CHICAGO --state ILLINOIS --zip 60616 --country USA --phone 123456789 --fax 2345178 --email sam.john@gmail.com --dob 04/05/1889 --note ‘this is an imp contact’ --street s.michigan  pobox 234 --city Chicago --state Illinois --zip 60616 --country USA 
           ant -Dargs="edit --contactid  --firstname Bill"
          ant -Dargs="view --contactid 1" 
          ant -Dargs="search --searchkey gaddameedi"
          ant -Dargs="delete --contactid 2" 
NOTE: Use single quote to enter space in any argument.

