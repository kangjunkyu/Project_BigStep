package com.ssafy.bigstep.model.dao;

import java.util.HashMap;

public interface LikeDao {
	
	int insertLike(HashMap<String, Object> map);
	
	int deleteLike(HashMap<String, Object> map);

}
