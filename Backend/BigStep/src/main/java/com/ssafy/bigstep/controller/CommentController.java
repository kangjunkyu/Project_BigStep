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

import com.ssafy.bigstep.model.dto.Comment;
import com.ssafy.bigstep.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
@Api(tags="댓글 관리 Api")
public class CommentController {
	
	@Autowired
	CommentService cService;
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@GetMapping("/comments/{diaryId}")
	@ApiOperation(value="댓글 목록 조회", notes="{diaryId}에 해당하는 diary에 대한 댓글 목록을 조회한다.")
	public ResponseEntity<?> getList(@PathVariable int diaryId) {
		try {
			List<Comment> list = cService.selectComments(diaryId);
			if(list == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{commentId}")
	@ApiOperation(value="댓글 상세 조회", notes="{commentId}에 해당하는 댓글의 상세 정보를 조회한다.")
	public ResponseEntity<?> getDetail(@PathVariable int commentId){
		try {
			Comment comment = cService.selectComment(commentId);
			if(comment == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/")
	@ApiOperation(value="댓글 등록", notes="JSON 형태로 입력받은 댓글을 등록한다.")
	public ResponseEntity<?> insertComment(@RequestBody Comment comment){
		try {
			int result = cService.insertComment(comment);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/")
	@ApiOperation(value="댓글 수정", notes="JSON 형태로 입력받은 댓글 정보를 바탕으로 댓글을 수정한다.")
	public ResponseEntity<?> updateComment(@RequestBody Comment comment){
		try {
			int result = cService.updateComment(comment);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{commentId}")
	@ApiOperation(value="댓글 삭제", notes="{commentId}에 해당하는 댓글을 삭제한다.")
	public ResponseEntity<?> updateComment(@PathVariable int commentId){
		try {
			int result = cService.deleteComment(commentId);
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
