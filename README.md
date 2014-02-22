sandbox
=======

sandbox for app building 


my-twitter-app
==============

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

Test Results for the Run :

Admins-MacBook-Pro:MyTwitter $ java -classpath   my-twitter-app-0.0.1-SNAPSHOT.jar:cqengine-1.0.3.jar:commons-lang3-3.1.jar com.giri.myprojects.twitter.server.MyTweetServer
>Alice -> I love the weather today
>Bob -> Oh, we lost!
>Bob -> at least it's sunny
>Alice
I love the weather today (21 Seconds ago)
>Bob
at least it's sunny (6 Seconds ago)
Oh, we lost! (16 Seconds ago)
>Charlie -> I'm in New York today! Anyone wants to have a coffee?
>Charlie follows Alice
>Charlie wall 
Charlie - I'm in New York today! Anyone wants to have a coffee? (15 Seconds ago)
Alice - I love the weather today (53 Seconds ago)
>Charlie follows Bob
>Charlie wall 
Charlie - I'm in New York today! Anyone wants to have a coffee? (38 Seconds ago)
Bob - at least it's sunny (56 Seconds ago)
Bob - Oh, we lost! (6 Seconds ago)
Alice - I love the weather today (15 Seconds ago)
>quit
GoodBye
Admins-MacBook-Pro:MyTwitter $ 
