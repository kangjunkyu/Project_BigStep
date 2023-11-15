package com.ssafy.bigstep.model.dto;

public class Diary {
	String diaryId;
	String userId;
	
	String title;
	String content;
	String date;	// 타입 추후 고려
	
	String img;
	String orgImg;
	
	
	public Diary(String userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}


	public String getDiaryId() {
		return diaryId;
	}


	public void setDiaryId(String diaryId) {
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


	@Override
	public String toString() {
		return "Diary [diaryId=" + diaryId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", img=" + img + ", orgImg=" + orgImg + "]";
	}
	
}
