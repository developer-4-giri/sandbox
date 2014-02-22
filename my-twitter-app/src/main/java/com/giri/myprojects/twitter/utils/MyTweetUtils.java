package com.giri.myprojects.twitter.utils;

import static com.googlecode.cqengine.query.QueryFactory.equal;
import static com.googlecode.cqengine.query.QueryFactory.or;
import static com.googlecode.cqengine.query.QueryFactory.orderByDescending;
import static com.googlecode.cqengine.query.QueryFactory.queryOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.giri.myprojects.twitter.model.MyPost;
import com.giri.myprojects.twitter.model.MyUser;
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;

public class MyTweetUtils {

	private static Map<String,MyUser> currentUsers = new HashMap<String,MyUser>();
	
	private static IndexedCollection<MyPost> indexedPosts = CQEngine.newInstance();
	private static long postCounter = 1;
	
	static{
		indexedPosts.addIndex(HashIndex.onAttribute(MyPost.POST_USER));
	}
	
	public static void postComment(String userName,String message){
		
		MyUser thisUser = currentUsers.get(userName) != null ? currentUsers.get(userName) : new MyUser(userName);
		List<Long> userPosts = thisUser.getUserPosts() != null ? thisUser.getUserPosts() : new ArrayList<Long>();  
	    
		long postId = postCounter++;
		indexedPosts.add(new MyPost(postId, userName, message));
	    
		userPosts.add(postId);
		
		thisUser.setUserPosts(userPosts);
		currentUsers.put(userName, thisUser);
	}
	
	public static void readComment(String userName){
		
		Query<MyPost> queryForPosts = equal(MyPost.POST_USER, userName);
		
		for (MyPost post : indexedPosts.retrieve(queryForPosts)) {
			
			System.out.println(post.getMessage() + " " + MyTimeUtils.findTimeDifference(post.getPostTime()));
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readWall(String userName){
		
		MyUser thisUser = currentUsers.get(userName) != null ? currentUsers.get(userName) : new MyUser(userName);
		
		List<String> usersToBeSearchedForPosts = thisUser.getSubscriptions() != null ? thisUser.getSubscriptions() : new ArrayList<String>();  
		usersToBeSearchedForPosts.add(userName);
		
		Collection<Query<MyPost>> queryCollection = MyCollectionQueryUtils.buildEqualsQueryFromCollection(usersToBeSearchedForPosts);

		Query<MyPost> queryForAllPosts =  null;
		if(usersToBeSearchedForPosts.size() > 1)
			queryForAllPosts =  or(queryCollection);
		else
			queryForAllPosts =  (Query<MyPost>) queryCollection.toArray()[0];
		
		for (MyPost post : indexedPosts.retrieve(queryForAllPosts, queryOptions(orderByDescending(MyPost.POST_TIME)))) {
			
			System.out.println(post.getPostUser()+ " - "+post.getMessage() + " " + MyTimeUtils.findTimeDifference(post.getPostTime()));
			
		}
	}

	public static void followUser(String userName,String userToFollow){
		
		MyUser thisUser = currentUsers.get(userName) != null ? currentUsers.get(userName) : new MyUser(userName);
		
		List<String> followsTheseUsers = thisUser.getSubscriptions() != null ? thisUser.getSubscriptions() : new ArrayList<String>();  
		followsTheseUsers.add(userToFollow);
		
		thisUser.setSubscriptions(followsTheseUsers);
		currentUsers.put(userName, thisUser);
	}	

}
