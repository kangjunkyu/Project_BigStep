package com.ssafy.bigstep.model.service;

import java.util.HashMap;

public interface LikeService {
	
	int insertLike(String userId, int diaryId);
	
	int deleteLike(String userId, int diaryId);
	
}
