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
import com.ssafy.bigstep.model.dao.UserDao;
import com.ssafy.bigstep.model.dto.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao uDao;
	
//	private UserServiceImpl() {
//		
//	}
	
	@Override
	@Transactional
	public int insertUser(User user) {
		return uDao.insertUser(user);
	}
	
	@Override
	@Transactional
	public int deleteUser(String id) {
		return uDao.deleteUser(id);
	}
	
	@Override 
	@Transactional
	public int updateUser(User user) {
		return uDao.updateUser(user);
	}
	
	@Override
	public List<User> selectUsers() {
		return uDao.selectUsers();
	}
	
	@Override
	public User selectUser(String id) {
		return uDao.selectUser(id);
	}

	@Override
	public User login(User user) {
		User loginUser = uDao.selectUser(user.getId());
		if(loginUser != null && loginUser.getPw().equals(user.getPw())) {
			return loginUser;
		}else {
			return null;			
		}
	}

	@Override
	public List<User> searchUsers(String word) {
		return uDao.searchUsers(word);
	}

	@Override
	public User searchByUID(String UID) {
		return uDao.searchByUID(UID);
	}
}
