package com.misynss.manager;

import java.util.List;

import com.misynss.dao.UserDAO;
import com.misynss.entity.Privilage;
import com.misynss.entity.User;

public interface UserManager {
	
	public int addUserMgr(User user);
	
	public int editUser(User user);
	
	public int deleteUserMgr(User user);
	
	public List<User> getUserList(String sql);
	
	public User getUserMgr(String string);

	public String getUserRole(int user_role_id);
	
	public List<Privilage> getPrivilagesList(int user_role_id);

	int updateAttemptNo(String userId);

	int reSetAttemptNo(String userId);
	
	public int saveChangePassWord(User user);

	int updateExrenalUser(User user);
		

}
