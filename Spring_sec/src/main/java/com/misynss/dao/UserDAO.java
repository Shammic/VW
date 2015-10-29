package com.misynss.dao;

import java.util.List;

import com.misynss.entity.Privilage;
import com.misynss.entity.User;

public interface UserDAO {

	public int insertUser(User user);

	public User getUser(String usr_id);

	public int delete(String id);
		
	public int updateAttemptNo(String userId);

	List<User> getUserList(String sql);

	String getUserRole(Integer userRole_id);

	public int saveChangePassWord(User user);

	int reSetAttemptNo(String userId);

	int updateUser(User user);

	int updateExrenalUser(User user);

	List<Privilage> getPrivilagesList(Integer userRole_id);

	
}
