package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable{

	private int postId;
	private String fileName;
	private String title;
	private ArrayList<String> commentList;
	private int votes;

	public Post(){}

	public int getPostId() {
		return postId;
	}

	public String getFileName() {
		return fileName;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getCommentList() {
		return commentList;
	}

	public int getVotes() {
		return votes;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setFileName(String postName) {
		this.fileName = postName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCommentList(ArrayList<String> commentList) {
		this.commentList = commentList;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

}
