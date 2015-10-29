package com.misynss.spring.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.misynss.common.Utility;
import com.misynss.entity.Privilage;
import com.misynss.entity.User;
import com.misynss.manager.UserManager;

public class MyUserDetailService implements UserDetailsService {

	UserManager userManagerImpl;
	Utility utility;

	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException, DataAccessException {

		System.out.println(userName);
		UserDetails userdetal = null;
		User user = userManagerImpl.getUserMgr(userName);
		
		List<Privilage> privilages = new ArrayList<Privilage>();
		 
		privilages = userManagerImpl.getPrivilagesList(user.getUser_role_id());
		user.setPrivilageList(privilages);
		// String authority =
		// userManagerImpl.getUserRole(user.getUser_role_id());
		// int a = userManagerImpl.updateAttemptNo(userName);
		// String str_today = utility.sysDate();
		try {
			userdetal = new MyUserDetails(user);
		} catch (Exception e) {
			System.out.println(e.toString());
			// throw new RuntimeException(e);

		}
		return userdetal;
	}

	public UserManager getUserManagerImpl() {
		return userManagerImpl;
	}

	public void setUserManagerImpl(UserManager userManagerImpl) {
		this.userManagerImpl = userManagerImpl;
	}

	public Utility getUtility() {
		return utility;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

}