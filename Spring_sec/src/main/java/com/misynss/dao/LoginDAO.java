package com.misynss.dao;

import com.misynss.entity.User;

public interface LoginDAO {
	
	String getPassword(String userName);
	
	User getUser(int userId);
	
	
}
