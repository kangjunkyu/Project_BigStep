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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bigstep.model.dto.User;
import com.ssafy.bigstep.model.service.FollowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/follow")
@CrossOrigin("*")
@Api(tags="팔로우 관리 Api")
public class FollowController {
	
	@Autowired
	FollowService fService;
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/{followerId}/{followingId}")
	@ApiOperation(value="팔로우 추가", notes="")
	public ResponseEntity<?> follow(@PathVariable String followerId, @PathVariable String followingId){
		try {
			int result = fService.insertFollow(followerId, followingId);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{followerId}/{followingId}")
	@ApiOperation(value="팔로우 삭제", notes="")
	public ResponseEntity<?> unfollow(@PathVariable String followerId, @PathVariable String followingId){
		try {
			int result = fService.deleteFollow(followerId, followingId);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@GetMapping("/followings/{followerId}")
	@ApiOperation(value="팔로잉 목록 조회", notes="{followerId}에 해당하는 유저가 팔로우하는 유저들의 목록 조회")
	public ResponseEntity<?> getFollowings(@PathVariable String followerId){
		try {
			List<User> followings = fService.selectFollowings(followerId);
			if(followings == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<List<User>>(followings, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/followers/{followingId}")
	@ApiOperation(value="팔로워 목록 조회", notes="{followerId}에 해당하는 유저를 팔로우하는 유저들의 목록 조회")
	public ResponseEntity<?> getFollowers(@PathVariable String followingId){
		try {
			List<User> followers = fService.selectFollowers(followingId);
			if(followers == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<List<User>>(followers, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}	
}
