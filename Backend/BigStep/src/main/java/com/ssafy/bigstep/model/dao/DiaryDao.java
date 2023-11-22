package com.ssafy.bigstep.model.dao;

import java.util.List;

import com.ssafy.bigstep.model.dto.Diary;

public interface DiaryDao {
	
	
	//insert
	public int insertDiary(Diary diary);
	
	//delete
	public int deleteDiary(int diaryId);
	
	//update
	public int updateDiary(Diary diary);
	
	//SelectAll
	public List<Diary> selectDiarys(String userId);
	
	//SelectOne
	public Diary selectDiary(int diaryId);
	
	// increase likeCnt
	public int increaseLikeCnt(int diaryId);
	
	// decrease likeCnt
	public int decreaseLikeCnt(int diaryId);
	
	public List<Diary> selectFollowingDiarys(String userId);


}
