package com.ssafy.bigstep.model.dto;

public class Todo {
	String date;
	String workout;
	String startTime;
	String endTime;
	
	
	public Todo(String date, String workout, String startTime, String endTime) {
		super();
		this.date = date;
		this.workout = workout;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getWorkout() {
		return workout;
	}


	public void setWorkout(String workout) {
		this.workout = workout;
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
		return "Todo [date=" + date + ", workOut=" + workout + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
	
}
