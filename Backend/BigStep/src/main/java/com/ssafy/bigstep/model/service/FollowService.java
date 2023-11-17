package com.ssafy.bigstep.model.service;

import java.util.List;

public interface FollowService {
	int insertFollow(String followerId, String followingId);
	
	int deleteFollow(String followerId, String followingId);
	
	List<String> selectFollowings(String followerId);
	
	List<String> selectFollowers(String followingId);
}
