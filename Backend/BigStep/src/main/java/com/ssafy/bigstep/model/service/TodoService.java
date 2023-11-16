package com.ssafy.bigstep.model.service;

import java.util.List;

import com.ssafy.bigstep.model.dto.Todo;

public interface TodoService {

	//insert
	public int insertTodo(Todo todo);
	
	//delete
	public int deleteTodo(int todoId);
	
	//update
	public int updateTodo(Todo todo);
	
	//SelectAll
	public List<Todo> selectTodos(int diaryId);
	
	//SelectOne
	public Todo selectTodo(int todoId);
	
}
