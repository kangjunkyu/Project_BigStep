package com.ssafy.bigstep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bigstep.model.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/like")
@CrossOrigin("*")
@Api(tags="좋아요 관리 Api")
public class LikeController {
	
	@Autowired
	LikeService lService;
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/{userId}/{diaryId}")
	@ApiOperation(value="좋아요 추가", notes="{userId}에 해당하는 유저가 {diaryId}에 해당하는 diary에 좋아요 추가")
	public ResponseEntity<?> insertLike(@PathVariable String userId, @PathVariable int diaryId){
		try {
			int result = lService.insertLike(userId, diaryId);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{userId}/{diaryId}")
	@ApiOperation(value="좋아요 해제", notes="{userId}에 해당하는 유저가 {diaryId}에 해당하는 diary에 좋아요 해제")
	public ResponseEntity<?> deleteLike(@PathVariable String userId, @PathVariable int diaryId){
		try {
			int result = lService.deleteLike(userId, diaryId);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
}
