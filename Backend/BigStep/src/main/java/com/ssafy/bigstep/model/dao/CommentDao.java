package com.ssafy.bigstep.model.dao;

import java.util.List;

import com.ssafy.bigstep.model.dto.Comment;

public interface CommentDao {
	
	// insert
	public int insertComment(Comment comment);
	
	// delete
	public int deleteComment(int commentId);
	
	// update
	public int updateComment(Comment comment);
	
	// selectAll
	public List<Comment> selectComments(int diaryId);
	
	// selectOne
	public Comment selectComment(int commentId);
	
	// delete by userId
	public int deleteCommentsByUserId(String userId);
		
	// delete by diaryId
	public int deleteCommentsByDiaryId(int diaryId);
}
