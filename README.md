# google.search
google.search

This project is an example for how to implement Page Object Model framework using Selenium + Test NG.

This is build using maven, and the scripts are expected to run on remote machines. Please use the GridHug.json and GridNode.json for running the scripts in remote machine

Pre-requisitic:
Install TestNG in your IDE (eclipse / Intellij) from http://testng.org/doc/download.html

Steps to implement:
1. Clone the project 
2. Import the project as maven project in the IDE
3. Download the selenium 3.0.1 (standalone server jar) from http://www.seleniumhq.org/download/
4. Once the project is resolved , configure the Gridhub using following command : java -jar selenium-server-standalone-3.0.1.jar -role hub -hubConfig  GridHub.json
5. Login in to another machine and configure the node - java -jar selenium-server-standalone-3.0.1.jar -role hub -nodeConfig  GridNode.json (Update the hub details in the json file with appropriate IP addresss )
6. Trigger the scripts using testng file.


For running the hub and nodes
java -jar selenium-server-standalone-3.0.1.j -role hub -hubConfig GridHub.json
java -jar selenium-server-standalone-3.0.1.j -role hub -nodeConfig GridNode.json
