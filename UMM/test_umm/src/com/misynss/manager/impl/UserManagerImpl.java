package com.misynss.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.misynss.dao.UserDAO;
import com.misynss.entity.Privilage;
import com.misynss.entity.User;
import com.misynss.manager.UserManager;

public class UserManagerImpl implements UserManager {

	private UserDAO userDAOImpl;

	@Override
	public int addUserMgr(User user) {
 
		int result = 0;
		result = userDAOImpl.insertUser(user);

		return result;
	}

	@Override
	public int editUser(User user) {
		// TODO Auto-generated method stub
		int result = userDAOImpl.updateUser(user);

		return result;
	}
	
	@Override
	public int updateExrenalUser(User user) {
		// TODO Auto-generated method stub
		int result = userDAOImpl.updateExrenalUser(user);
		
		return result;
	}

	@Override
	public int deleteUserMgr(User user) {
	int	result = userDAOImpl.delete(user.getUsrid());
		return result;
	}

	@Override
	public List<User> getUserList(String sql) {
		List<User> userList = new ArrayList<User>();

		userList = userDAOImpl.getUserList(sql);
		return userList;
	}
	
	@Override
	public int updateAttemptNo(String userId) {
		int result = userDAOImpl.updateAttemptNo(userId);
		return result;
	}
	
	@Override
	public int reSetAttemptNo(String userId) {
		int result = userDAOImpl.reSetAttemptNo(userId);
		return result;
	}

	@Override
	public User getUserMgr(String user_id) {
		User user = new User();
		user = userDAOImpl.getUser(user_id);
		return user;
	}
	
	@Override
	public String getUserRole(int user_role_id) {
		
		String userRole = userDAOImpl.getUserRole(user_role_id);
		
		return userRole;
	}

	@Override
	public int saveChangePassWord(User user) {
		int result = 0;
		result = userDAOImpl.saveChangePassWord(user);

		return result;
	}

	public UserDAO getUserDAOImpl() {
		return userDAOImpl;
	}

	public void setUserDAOImpl(UserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	@Override
	public List<Privilage> getPrivilagesList(int user_role_id) {
		return userDAOImpl.getPrivilagesList(user_role_id);
	}


}
