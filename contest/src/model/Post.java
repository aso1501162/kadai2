package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable{

	private int postId;
	private String postName;
	private String title;
	private ArrayList<String> commentList;

	public Post(){}

	public int getPostId() {
		return postId;
	}

	public String getPostName() {
		return postName;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getCommentList() {
		return commentList;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCommentList(ArrayList<String> commentList) {
		this.commentList = commentList;
	}


}
