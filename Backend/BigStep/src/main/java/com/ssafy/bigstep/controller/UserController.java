package com.ssafy.bigstep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.ssafy.bigstep.model.dto.User;
import com.ssafy.bigstep.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user-api")
@CrossOrigin("*")
@Api(tags="유저 관리 Api")
public class UserController {

	@Autowired
	UserService uService;
	
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/users")
	@ApiOperation(value="유저 목록 조회", notes="전체 유저 목록을 조회한다.")
	public ResponseEntity<?> selectUsers() {
		try {
			List<User> userList = uService.selectUsers();
			if (userList == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value="유저 상세 조회", notes="{id}에 해당하는 유저의 상세 정보를 조회한다.")
	public ResponseEntity<?> selectUser(@PathVariable String id){
		try {
			User user = uService.selectUser(id);
			if(user == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		}catch (Exception e) {
			return exceptionHandling(e);
		}
			
	}

	@PostMapping("/user")
	@ApiOperation(value="유저 등록", notes="JSON 형태로 입력받은 유저 정보를 등록한다.")
	public ResponseEntity<?> insertUser(@RequestBody User user) {
		try {
			int result = uService.insertUser(user);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);				
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value="유저 삭제", notes="{id}에 해당하는 유저 정보를 삭제한다.")
	public ResponseEntity<?> deleteUser(@PathVariable String id){
		try {
			int result = uService.deleteUser(id);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);				
			}
		}catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/user")
	@ApiOperation(value="유저 수정", notes="JSON 형태로 입력받은 데이터를 바탕으로 유저 정보를 수정한다.")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		try {
			int result = uService.updateUser(user);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);				
			}
		}catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	

	@PostMapping("/user/login")
	@ApiOperation(value="로그인", notes="JSON 형태로 입력받은 유저 정보를 이용하여 로그인을 시도한다.")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		User loginUser = uService.login(user);
		if (loginUser == null)
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

		session.setAttribute("loginUser", loginUser);
		return new ResponseEntity<User>(loginUser, HttpStatus.OK);
	}

	@PostMapping("/user/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
