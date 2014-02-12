package com.giri.myprojects.twitter.utils;

import static com.googlecode.cqengine.query.QueryFactory.equal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.giri.myprojects.twitter.model.MyPost;
import com.googlecode.cqengine.query.Query;

public class MyCollectionQueryUtils {
	
	public static Collection<Query<MyPost>> buildEqualsQueryFromCollection(List<String> manyUsers){
		
		Collection<Query<MyPost>> queryList = new ArrayList<Query<MyPost>>();
		
		for(String userName : manyUsers)
			queryList.add(equal(MyPost.POST_USER, userName));
			
		return queryList;
	} 


}
