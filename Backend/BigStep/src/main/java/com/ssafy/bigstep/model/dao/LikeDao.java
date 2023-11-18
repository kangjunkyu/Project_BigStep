package com.ssafy.bigstep.model.dao;

import java.util.HashMap;

public interface LikeDao {
	
	int insertLike(HashMap<String, Object> map);
	
	int deleteLike(HashMap<String, Object> map);
	
	// delete by userId
	public int deleteLikesByUserId(String userId);
				
	// delete by diaryId
	public int deleteLikesByDiaryId(int diaryId);
}
