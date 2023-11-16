package com.ssafy.bigstep.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.bigstep.model.dao.CommentDao;
import com.ssafy.bigstep.model.dto.Comment;

@Service
public class CommentServiceimpl implements CommentService{
	
	@Autowired
	CommentDao cDao;

	@Override
	public int insertComment(Comment comment) {
		return cDao.insertComment(comment);
	}

	@Override
	public int deleteComment(int commentId) {
		return cDao.deleteComment(commentId);
	}

	@Override
	public int updateComment(Comment comment) {
		return cDao.updateComment(comment);
	}

	@Override
	public List<Comment> selectComments(int diaryId) {
		return cDao.selectComments(diaryId);
	}

	@Override
	public Comment selectComment(int commentId) {
		return cDao.selectComment(commentId);
	}
}
