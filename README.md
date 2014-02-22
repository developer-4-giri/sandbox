sandbox
=======

sandbox for app building 


How To Build:
 - Check out the project (as Maven project)
 - Build is using the maven install command (This will compile the code, run the Junit tests and create a jar in the target directory).
 
 To run the program :
  - Copy the jar file created in the above build process to a directory 
  - Make sure you have following dependencies resolved and if possible copy them to the same folder as the 
  	- cqengine-1.0.3.jar
  	- commons-lang3-3.1.jar
  - Run the following command (you will need to have java 1.6 installed on the machine)
  	java -classpath my-twitter-app-0.0.1-SNAPSHOT.jar:cqengine-1.0.3.jar:commons-lang3-3.1.jar com.giri.myprojects.twitter.server.MyTweetServer
