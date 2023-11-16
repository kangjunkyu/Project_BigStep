package com.ssafy.bigstep.model.dto;

public class Comment {
	int commentId;
	int diaryId;
	String userId;
	String nickname;
	String content;
	
	public Comment() {
		
	}

	public Comment(int diaryId, String userId, String nickname, String content) {
		super();
		this.diaryId = diaryId;
		this.userId = userId;
		this.nickname = nickname;
		this.content = content;
	}


	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "Comment [diaryId=" + diaryId + ", userId=" + userId + ", nickname=" + nickname + ", content=" + content
				+ "]";
	}
	
}
