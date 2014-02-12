package com.giri.myprojects.twitter.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.giri.myprojects.twitter.utils.MyTweetUtils;

public class MyTweetServer {
	
	private static final String BLANK_INPUT = "";

	private static final String COMMAND_PARAM_SEPARATOR = " ";

	private static final String MESSAGE_GOODBYE = "GoodBye";
	
	private static final String COMMAND_QUIT = "quit";
	private static final String COMMAND_FOLLOW = "follows";
	private static final String COMMAND_POST = "->";
	private static final String COMMAND_WALL = "wall";

	public static void main(String[] args){
		
		MyTweetServer server = new MyTweetServer();
		server.listenForUserCommands();
		
	}
	
	public void listenForUserCommands(){
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String commandStr = BLANK_INPUT;

		System.out.print(">");

		try {
		
			while (!COMMAND_QUIT.equalsIgnoreCase(commandStr)) {
			
				commandStr = consoleReader.readLine();

				if(COMMAND_QUIT.equalsIgnoreCase(commandStr)){
					
					System.out.println(MESSAGE_GOODBYE);
				}
				else{
					
					processUserInput(commandStr);
					System.out.print(">");
					
				}
			}
			
			consoleReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void processUserInput(String commandStr){

		String[] commandArray = commandStr.split(COMMAND_PARAM_SEPARATOR);

		String userName = commandArray[0];
		String commandParam = null;
		
		if(commandArray.length > 1 ){
			
			if(COMMAND_WALL.equalsIgnoreCase(commandArray[1])){
				
				MyTweetUtils.readWall(userName);
			}
			else if(COMMAND_POST.equalsIgnoreCase(commandArray[1])){

				commandParam = StringUtils.join(Arrays.copyOfRange(commandArray, 2, commandArray.length), " ");
				MyTweetUtils.postComment(userName,commandParam);
			
			}else if(COMMAND_FOLLOW.equalsIgnoreCase(commandArray[1])){
			
				commandParam = commandArray[2];
				MyTweetUtils.followUser(userName,commandParam);
				
			}
		}
		else{
			
			MyTweetUtils.readComment(userName);
		}
		
	}

}
