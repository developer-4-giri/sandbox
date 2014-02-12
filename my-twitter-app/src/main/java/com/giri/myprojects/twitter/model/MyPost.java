package com.giri.myprojects.twitter.model;

import java.util.Date;
import java.util.GregorianCalendar;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;

public class MyPost {
	
	private long postId;
	private String postUser;
	private String message;
	private Date postTime;
	
	public MyPost(long postId, String postUser, String message) {
		super();
		this.postId = postId;
		this.postUser = postUser;
		this.message = message;
		this.postTime = GregorianCalendar.getInstance().getTime();
	}
	
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public String getPostUser() {
		return postUser;
	}
	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
	//INFO: CQEngine Specific thing - refer @(https://code.google.com/p/cqengine/)
	 public static final Attribute<MyPost, String> POST_USER = new SimpleAttribute<MyPost, String>("postuser") {
	        public String getValue(MyPost userPost) { return userPost.postUser; }
	 };
	
	 public static final Attribute<MyPost, Date> POST_TIME = new SimpleAttribute<MyPost, Date>("posttime") {
	        public Date getValue(MyPost userPost) { return userPost.postTime; }
	 };
	 
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + (int) (postId ^ (postId >>> 32));
		result = prime * result + ((postTime == null) ? 0 : postTime.hashCode());
		result = prime * result + ((postUser == null) ? 0 : postUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyPost other = (MyPost) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (postId != other.postId)
			return false;
		if (postTime == null) {
			if (other.postTime != null)
				return false;
		} else if (!postTime.equals(other.postTime))
			return false;
		if (postUser == null) {
			if (other.postUser != null)
				return false;
		} else if (!postUser.equals(other.postUser))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyPost [postId=");
		builder.append(postId);
		builder.append(", postUser=");
		builder.append(postUser);
		builder.append(", message=");
		builder.append(message);
		builder.append(", postTime=");
		builder.append(postTime);
		builder.append("]");
		return builder.toString();
	}
	

}
