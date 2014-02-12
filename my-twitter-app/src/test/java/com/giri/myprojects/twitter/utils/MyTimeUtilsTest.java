package com.giri.myprojects.twitter.utils;

import static net.java.quickcheck.generator.PrimitiveGeneratorSamples.anyDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import java.util.Date;

import org.junit.Test;

public class MyTimeUtilsTest {

	@Test
	public void testFindTimeDifference() {
		Date randomDate = anyDate();
		
		String result = MyTimeUtils.findTimeDifference(randomDate);
		
		assertThat(result,not(isEmptyOrNullString()));
		assertThat(result,anyOf(containsString(" Days ago"),containsString(" Hours ago"),containsString(" Minutes ago"),containsString(" Seconds ago")));
	}

	@Test(expected=NullPointerException.class)
	public void nullDatesThrowsException() {
		
		MyTimeUtils.findTimeDifference(null);
		
	}
	
}
