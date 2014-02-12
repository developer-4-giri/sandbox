package com.giri.myprojects.twitter.model;

import java.util.List;

public class MyUser {
	
	public MyUser(String userName) {
		super();
		this.userName = userName;
	}
	
	private String userName;
	private List<Long> userPosts;
	private List<String> subscriptions;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Long> getUserPosts() {
		return userPosts;
	}
	public void setUserPosts(List<Long> userPosts) {
		this.userPosts = userPosts;
	}
	public List<String> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<String> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPosts == null) ? 0 : userPosts.hashCode());
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
		MyUser other = (MyUser) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPosts == null) {
			if (other.userPosts != null)
				return false;
		} else if (!userPosts.equals(other.userPosts))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyUser [userName=");
		builder.append(userName);
		builder.append(", userPosts=");
		builder.append(userPosts);
		builder.append("]");
		return builder.toString();
	}
	
}
