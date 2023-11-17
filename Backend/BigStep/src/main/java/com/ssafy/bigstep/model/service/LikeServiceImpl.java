package com.ssafy.bigstep.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.bigstep.model.dao.DiaryDao;
import com.ssafy.bigstep.model.dao.LikeDao;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao lDao;
	
	@Autowired
	DiaryDao dDao;

	@Override
	public int insertLike(String userId, int diaryId) {
		dDao.increaseLikeCnt(diaryId);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("diaryId", diaryId);
		return lDao.insertLike(map);
	}

	@Override
	public int deleteLike(String userId, int diaryId) {
		dDao.decreaseLikeCnt(diaryId);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("diaryId", diaryId);
		return lDao.deleteLike(map);
	}

}
