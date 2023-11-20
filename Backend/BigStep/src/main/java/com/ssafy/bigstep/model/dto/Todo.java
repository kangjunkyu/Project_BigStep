package com.ssafy.bigstep.model.dto;

public class Todo {
	int todoId;
	int diaryId;
	String userId;
	
	
	String date;
	String workout;
	
	int startHour;
	int startMinute;
	int endHour;
	int endMinute;
	
	boolean isComplete;
	
	public Todo() {
		
	}
	
	
	public Todo(int diaryId, String userId, String date, String workout, int startHour, int startMinute, int endHour,
			int endMinute) {
		super();
		this.diaryId = diaryId;
		this.userId = userId;
		this.date = date;
		this.workout = workout;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
	}


	public int getTodoId() {
		return todoId;
	}


	public void setTodoId(int todoId) {
		this.todoId = todoId;
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


	public int getStartHour() {
		return startHour;
	}


	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}


	public int getStartMinute() {
		return startMinute;
	}


	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}


	public int getEndHour() {
		return endHour;
	}


	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}


	public int getEndMinute() {
		return endMinute;
	}


	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	

	public boolean isComplete() {
		return isComplete;
	}


	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}


	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", diaryId=" + diaryId + ", userId=" + userId + ", date=" + date
				+ ", workout=" + workout + ", startHour=" + startHour + ", startMinute=" + startMinute + ", endHour="
				+ endHour + ", endMinute=" + endMinute + ", isComplete=" + isComplete + "]";
	}
	
}
