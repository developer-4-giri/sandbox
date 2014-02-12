package com.giri.myprojects.twitter.utils;

import java.util.Date;
import java.util.GregorianCalendar;

public class MyTimeUtils {

	private static final String CLOSING_CURLY_BRACKET = ")";
	private static final String OPENING_CURLY_BRACKET = "(";

	public static String findTimeDifference(Date origTime){

		StringBuffer returnMessage  = new StringBuffer(OPENING_CURLY_BRACKET);
		
        Date currentTime = GregorianCalendar.getInstance().getTime();

        long diff = currentTime.getTime() - origTime.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        int diffInDays = (int) ((currentTime.getTime() - origTime.getTime()) / (1000 * 60 * 60 * 24));

        if (diffInDays > 1) 
        	returnMessage.append(diffInDays).append(" Days ago").append(CLOSING_CURLY_BRACKET);
        
        else if (diffHours > 1) 
        	returnMessage.append(diffHours).append(" Hours ago").append(CLOSING_CURLY_BRACKET);
        
        else if (diffMinutes > 1) 
        	returnMessage.append(diffMinutes).append(" Minutes ago").append(CLOSING_CURLY_BRACKET);
        
        else
        	returnMessage.append(diffSeconds).append(" Seconds ago").append(CLOSING_CURLY_BRACKET);
		
		return returnMessage .toString();
	}
}
