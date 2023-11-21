package com.ssafy.bigstep.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.bigstep.model.dao.CommentDao;
import com.ssafy.bigstep.model.dao.DiaryDao;
import com.ssafy.bigstep.model.dao.FollowDao;
import com.ssafy.bigstep.model.dao.LikeDao;
import com.ssafy.bigstep.model.dao.TodoDao;
import com.ssafy.bigstep.model.dto.Diary;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	DiaryDao dDao;
	
	@Override
	@Transactional
	public int insertDiary(Diary diary) {
		return dDao.insertDiary(diary);
	}

	@Override
	@Transactional
	public int deleteDiary(int diaryId) {
		return dDao.deleteDiary(diaryId);
	}

	@Override
	@Transactional
	public int updateDiary(Diary diary) {
		return dDao.updateDiary(diary);
	}

	@Override
	public List<Diary> selectDiarys(String userId) {
		return dDao.selectDiarys(userId);
	}

	@Override
	public Diary selectDiary(int diaryId) {
		return dDao.selectDiary(diaryId);
	}

	@Override
	@Transactional
	public int increaseLikeCnt(int diaryId) {
		return dDao.increaseLikeCnt(diaryId);
	}
	
	@Override
	public List<Diary> selectFollowingDiarys(String userId) {
		return dDao.selectFollowingDiarys(userId);
	}


}
