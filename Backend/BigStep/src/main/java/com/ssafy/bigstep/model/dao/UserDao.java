package com.ssafy.bigstep.model.dao;

import java.util.List;

import com.ssafy.bigstep.model.dto.User;

public interface UserDao {

	// insert
	public int insertUser(User user);

	// delete(회원탈퇴)
	public int deleteUser(String id);

	// update
	public int updateUser(User user);

	// SelectAll
	public List<User> selectUsers();

	// SelectOne
	public User selectUser(String id);
	
	// search
	public List<User> searchUsers(String word);
	
	// searchByUID
	public User searchByUID(String UID);

}
