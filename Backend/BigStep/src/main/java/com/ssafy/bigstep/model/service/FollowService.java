package com.ssafy.bigstep.model.service;

import java.util.List;

import com.ssafy.bigstep.model.dto.User;

public interface FollowService {
	int insertFollow(String followerId, String followingId);
	
	int deleteFollow(String followerId, String followingId);
	
	List<User> selectFollowings(String followerId);
	
	List<User> selectFollowers(String followingId);
}
