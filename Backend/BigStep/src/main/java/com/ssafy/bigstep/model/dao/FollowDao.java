package com.ssafy.bigstep.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.bigstep.model.dto.User;

public interface FollowDao {
	
	int insertFollow(HashMap<String, String> idMap);
	
	int deleteFollow(HashMap<String, String> idMap);
	
	List<User> selectFollowings(String followerId);
	
	List<User> selectFollowers(String followingId);

}
