package com.list.models;

public class AlertModal {
	
	private String userName = "";
	private String userPhoto = "";
	private String tweatString = "";
	private String tweatPhoto = "";
	private String tweatTime = "";
	
	public void setUserName(String username)
	{
		this.userName = username;
	}
	public void setUserPhoto(String userphoto)
	{
		this.userPhoto = userphoto;
	}
	public void setTweatString(String tweatString)
	{
		this.tweatString = tweatString;
	}
	public void setTweatPhoto(String tweatPhoto)
	{
		this.tweatPhoto = tweatPhoto;
	}
	public void setTweatTime(String TweatTime)
	{
		this.tweatTime = TweatTime;
	}
	
	
	public String getUserName()
	{
		 return this.userName;
	}
	public String getUserPhoto()
	{
		return this.userPhoto;
	}
	public String getTweatString()
	{
		return this.tweatString;
	}
	public String getTweatPhoto()
	{
		return this.tweatPhoto;
	}
	public String getTweatTime()
	{
		return this.tweatTime;
	}

}
