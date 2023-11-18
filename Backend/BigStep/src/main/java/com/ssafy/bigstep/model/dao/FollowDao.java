package com.ssafy.bigstep.model.dao;

import java.util.HashMap;
import java.util.List;

public interface FollowDao {
	
	int insertFollow(HashMap<String, String> idMap);
	
	int deleteFollow(HashMap<String, String> idMap);
	
	List<String> selectFollowings(String followerId);
	
	List<String> selectFollowers(String followingId);

}
