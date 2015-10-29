package com.misynss.spring.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.misynss.entity.Privilage;
import com.misynss.entity.User;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final boolean isAccountLock;
	private final String userName;
	private final String password;
	private final Integer userRoleId;
	// me list eka thamai getAuthorities kiyana method eken return karanne.
	private  List<GrantedAuthority> grantedAuthorities ;//= new ArrayList<GrantedAuthority>();
	
	public MyUserDetails(User user) {
		this.userName = user.getUsrid();
		this.password = user.getPassword();
		this.userRoleId = user.getUser_role_id();
		
		if(user.getUsrstatus()=='L'){
			this.isAccountLock = false;
        }else {
        	this.isAccountLock = true;
        }
		
		final Integer role = user.getUser_role_id();
		this.grantedAuthorities = getAuthorityList(user.getPrivilageList());
	}
	
	 public List<GrantedAuthority>  getAuthorityList(List<Privilage> privilages){
		 List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		 
		 
		 for (Iterator iterator = privilages.iterator(); iterator.hasNext();) {
			final Privilage privilage = (Privilage) iterator.next();
			GrantedAuthority grantedAuthority = new GrantedAuthority() {

				private static final long serialVersionUID = -5789401084459321019L;

				@Override
				public String getAuthority() {
					// TODO Auto-generated method stub
					return privilage.getName();
				}
			};
			grantedAuthorities.add(grantedAuthority);
		}
		 
			return grantedAuthorities;
	 }

	 @Override
     public boolean isEnabled() {
         return true;
     }
    
     @Override
     public boolean isCredentialsNonExpired() {
         return true;
     }
    
     @Override
     public boolean isAccountNonLocked() {
    	 return isAccountLock;
     }
    
     @Override
     public boolean isAccountNonExpired() {
         return true;
     }
    
     @Override
     public String getUsername() {
    	 return this.userName;
     }
    
     @Override
     public String getPassword() {
         return this.password;
     }
    
     @Override
     public Collection<GrantedAuthority> getAuthorities() {
    	 return this.grantedAuthorities;
         //return getAuthorities(user.getUser_role_id());
     }
     
     public Integer getUserRoleId() {
 		return userRoleId;
 	}

	public boolean equals(Object usr) {
         if (usr instanceof MyUserDetails) {
             return (((MyUserDetails) usr).getUsername()).equals(this.userName);
         }
     return false;
     }

	public int hashCode() {
         return this.userRoleId.intValue();
     }

}
