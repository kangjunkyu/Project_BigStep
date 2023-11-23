package com.ssafy.bigstep.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.bigstep.model.dao.FollowDao;
import com.ssafy.bigstep.model.dto.User;

@Service
public class FollowServiceImpl implements FollowService{
	
	@Autowired
	FollowDao fDao;
	
	@Override
	public int insertFollow(String followerId, String followingId) {
		HashMap<String, String> idMap = new HashMap<>();
		idMap.put("followerId", followerId);
		idMap.put("followingId", followingId);
		return fDao.insertFollow(idMap);
	}

	@Override
	public int deleteFollow(String followerId, String followingId) {
		HashMap<String, String> idMap = new HashMap<>();
		idMap.put("followerId", followerId);
		idMap.put("followingId", followingId);
		return fDao.deleteFollow(idMap);
	}

	@Override
	public List<User> selectFollowings(String followerId) {
		return fDao.selectFollowings(followerId);
	}

	@Override
	public List<User> selectFollowers(String followingId) {
		return fDao.selectFollowers(followingId);
	}

}
