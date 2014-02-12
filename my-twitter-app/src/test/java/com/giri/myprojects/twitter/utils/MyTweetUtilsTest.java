package com.giri.myprojects.twitter.utils;

import static net.java.quickcheck.generator.PrimitiveGeneratorSamples.anyLetterString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTweetUtilsTest {

	private final ByteArrayOutputStream outConsoleContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outConsoleContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}

	@Test
	public void testPostCommentAndReadComment() {
		String randomUser = anyLetterString();
		String randomMessage = anyLetterString();
		
		MyTweetUtils.postComment(randomUser,randomMessage);
		MyTweetUtils.readComment(randomUser);

		assertThat(outConsoleContent.toString(), containsString(" Seconds ago"));
		assertThat(outConsoleContent.toString(), containsString(randomMessage));
	}

	@Test
	public void testFollowUserAndReadWall() {
		String randomUser_1 = anyLetterString();
		String randomMessage_1 = anyLetterString();
		
		String randomUser_2 = anyLetterString();
		String randomMessage_2 = anyLetterString();

		MyTweetUtils.postComment(randomUser_1,randomMessage_1);
		MyTweetUtils.postComment(randomUser_2,randomMessage_2);
		
		MyTweetUtils.followUser(randomUser_1, randomUser_2);
		
		MyTweetUtils.readWall(randomUser_1);
		
		assertThat(outConsoleContent.toString(), containsString(" Seconds ago"));
		assertThat(outConsoleContent.toString(), containsString(randomUser_2));
		assertThat(outConsoleContent.toString(), containsString(randomMessage_2));
		
	}

}
