package com.giri.myprojects.twitter.utils;

import static net.java.quickcheck.generator.PrimitiveGeneratorSamples.anyInteger;
import static net.java.quickcheck.generator.PrimitiveGeneratorSamples.anyLetterString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.giri.myprojects.twitter.model.MyPost;
import com.googlecode.cqengine.query.Query;

public class MyCollectionQueryUtilsTest {

	@Test
	public void testBuildEqualsQueryFromCollection() {
		List<String> stringCollection = new ArrayList<String>();
		int collectionLength = anyInteger(2, 5);
		
		for(int counter = 0 ; counter < collectionLength ; counter++)
			stringCollection.add(anyLetterString(3, 9));

		Collection<Query<MyPost>> result = MyCollectionQueryUtils.buildEqualsQueryFromCollection(stringCollection);

		assertThat(result.size(),equalTo(stringCollection.size()));
		assertThat(result, instanceOf(ArrayList.class));

		int counter = 0;
		for(Query<MyPost> query: result)
			assertThat( query.toString(), equalTo("Equal{attributeType=java.lang.String, attributeName=postuser, value="+stringCollection.get(counter++)+"}"));
		
	}

	@Test
	public void shouldHandleEmptyString() {
		List<String> stringCollection = new ArrayList<String>();
		int collectionLength = anyInteger(2, 5);
		
		for(int counter = 0 ; counter < collectionLength ; counter++)
			stringCollection.add("");

		Collection<Query<MyPost>> result = MyCollectionQueryUtils.buildEqualsQueryFromCollection(stringCollection);

		assertThat(result.size(),equalTo(stringCollection.size()));
		assertThat(result, instanceOf(ArrayList.class));

		for(Query<MyPost> query: result)
			assertThat( query.toString(), equalTo("Equal{attributeType=java.lang.String, attributeName=postuser, value=}"));
		
	}
	
}
