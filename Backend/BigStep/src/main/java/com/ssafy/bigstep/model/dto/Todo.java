package com.ssafy.bigstep.model.dto;

public class Todo {
	String date;
	String workOut;
	String startTime;
	String endTime;
	
	
	public Todo(String date, String workOut, String startTime, String endTime) {
		super();
		this.date = date;
		this.workOut = workOut;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getWorkOut() {
		return workOut;
	}


	public void setWorkOut(String workOut) {
		this.workOut = workOut;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	////////////////////////////////////////
	// end - start로 운동시간 계산하는 method 만들기
	////////////////////////////////////////
	
	@Override
	public String toString() {
		return "Todo [date=" + date + ", workOut=" + workOut + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
	
}
