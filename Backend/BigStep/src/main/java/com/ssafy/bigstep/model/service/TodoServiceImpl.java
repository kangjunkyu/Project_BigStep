package com.ssafy.bigstep.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.bigstep.model.dao.TodoDao;
import com.ssafy.bigstep.model.dto.Todo;
import com.ssafy.bigstep.model.dto.User;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoDao tDao;


	@Override
	@Transactional
	public int insertTodo(Todo todo) {
		return tDao.insertTodo(todo);
	}

	@Override
	@Transactional
	public int deleteTodo(int todoid) {
		return tDao.deleteTodo(todoid);
	}

	@Override
	@Transactional
	public int updateTodo(Todo todo) {
		return tDao.updateTodo(todo);
	}

	@Override
	public List<Todo> selectTodos(int diaryId) {
		return tDao.selectTodos(diaryId);
	}

	@Override
	public Todo selectTodo(int todoid) {
		return tDao.selectTodo(todoid);
	}
}
