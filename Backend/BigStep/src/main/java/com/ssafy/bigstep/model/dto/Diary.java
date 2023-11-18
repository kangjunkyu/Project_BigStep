package com.ssafy.bigstep.model.dto;

public class Diary {
	int diaryId;
	String userId;
	
	String title;
	String content;
	String date;	// 타입 추후 고려
	
	String img;
	String orgImg;
	
	int likeCnt;
	
	
	public Diary() {}

	public Diary(String userId, String title, String content) {
		this.userId = userId;
		this.title = title;
		this.content = content;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getOrgImg() {
		return orgImg;
	}


	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	public int getLikeCnt() {
		return likeCnt;
	}
	
	
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	@Override
	public String toString() {
		return "Diary [diaryId=" + diaryId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", img=" + img + ", orgImg=" + orgImg + ", likeCnt=" + likeCnt +  "]";
	}
	
}
