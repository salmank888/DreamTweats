package com.list.models;

public class CommentModal {
	
	private String userName = "";
	private String userPhoto = "";
	private String commentString1 = "";
	private String commentString2 = "";
	private String tweatTime = "";
	
	public void setUserName(String username)
	{
		this.userName = username;
	}
	public void setUserPhoto(String userphoto)
	{
		this.userPhoto = userphoto;
	}
	public void setCommentString1(String tweatString)
	{
		this.commentString1 = tweatString;
	}
	public void setCommentString2(String tweatPhoto)
	{
		this.commentString2 = tweatPhoto;
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
	public String getCommentString1()
	{
		return this.commentString1;
	}
	public String getCommentString2()
	{
		return this.commentString2;
	}
	public String getTweatTime()
	{
		return this.tweatTime;
	}

}
