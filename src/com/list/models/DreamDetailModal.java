package com.list.models;

public class DreamDetailModal {

	public String userName = "";
	public String userPhoto = "";
	public String tweetTime = "";
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public void setUserPhoto(String userPhoto)
	{
		this.userPhoto = userPhoto;
	}
	public void setTweetTime(String tweetTime)
	{
		this.tweetTime = tweetTime;
	}
	public String getUserName()
	{
		return this.userName;
	}
	public String getUserPhoto()
	{
		return this.userPhoto;
	}
	public String getTweetTime()
	{
		return this.tweetTime;
	}
}
