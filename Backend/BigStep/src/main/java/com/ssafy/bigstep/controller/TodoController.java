package com.ssafy.bigstep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bigstep.model.dto.Todo;
import com.ssafy.bigstep.model.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
@Api(tags="할일 관리 Api")
public class TodoController {
	
	@Autowired
	TodoService tService;
	
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/todos/{diaryId}")
	@ApiOperation(value="Todo 목록 조회", notes="{diaryId}에 해당하는 diary에 대한 todo 목록을 조회한다.")
	public ResponseEntity<?> selectTodos(@PathVariable int diaryId) {
		try {
			List<Todo> todoList = tService.selectTodos(diaryId);
			if (todoList == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{todoId}")
	@ApiOperation(value="Todo 상세 조회", notes="{todoId}에 해당하는 todo 상세 정보를 조회한다.")
	public ResponseEntity<?> selectTodo(@PathVariable int todoId){
		try {
			Todo todo = tService.selectTodo(todoId);
			if(todo == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Todo>(todo, HttpStatus.OK);
			}
		}catch (Exception e) {
			return exceptionHandling(e);
		}
			
	}

	@PostMapping("/")
	@ApiOperation(value="Todo 등록", notes="JSON 형태로 입력받은 todo를 등록한다.")
	public ResponseEntity<?> insertTodo(@RequestBody Todo todo) {
		try {
			int result = tService.insertTodo(todo);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{todoId}")
	@ApiOperation(value="Todo 삭제", notes="{todoId}에 해당하는 todo를 삭제한다.")
	public ResponseEntity<?> deleteUser(@PathVariable int todoId){
		try {
			int result = tService.deleteTodo(todoId);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		}catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/")
	@ApiOperation(value="Todo 수정", notes="JSON 형태로 입력받은 todo 정보를 바탕으로 todo를 수정한다.")
	public ResponseEntity<?> updateUser(@RequestBody Todo todo){
		System.out.println(todo);
		try {
			int result = tService.updateTodo(todo);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		}catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
}
