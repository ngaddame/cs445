cs445
=====

OODP

1. Install git using the command mentioned below
 command:   sudo apt-get install git

2. clone project from github
 command:   git clone https://github.com/ngaddame/cs445.git

3. go to cs445/ContactManagement directory
command:    cd ./cs445/ContactManagement

4. install java using the below commands 
command:    sudo apt-get install openjdk-7-jre-headless
command:    sudo apt-get install openjdk-7-jdk

5. install ant 
command:    sudo apt-get install ant

6. run unit test.
Make sure the cms_master.xml does not contain any contacts. It should have contactId=1.
command:    ant test

7. run application.
command:    
ant -Dargs="load --filename load_contacts.xml�
ant -Dargs="listall�
ant -Dargs="add --prefix mr. --firstname SAM --middlename MARIA --lastname JOHN --suffix JR. --city CHICAGO --state ILLINOIS --zip 60616 --country USA --phone 123456789 --fax 2345178 --email sam.john@gmail.com --dob 04/05/1889 --note �this is an imp contact� --street s.michigan �pobox 234 --city Chicago --state Illinois --zip 60616 --country USA�
ant -Dargs="delete --contactid 71 �
ant -Dargs="edit --contactid 72 --firstname Bil�
ant -Dargs="view -�contactid 72�
ant -Dargs="search -�searchkey gadda�


NOTE: Use single quote to enter space in any argument.

