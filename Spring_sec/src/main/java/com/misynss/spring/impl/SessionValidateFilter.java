package com.misynss.spring.impl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.misynss.entity.User;


public class SessionValidateFilter implements Filter  {
	
	 //static final String FILTER_APPLIED = "__spring_security_expired_session_filter_applied";
	private int customSessionExpiredErrorCode = 901;

	// Map<String, String> loginMap = ContextListener.loginMap;

	@Override
	public void destroy() {
		// Do nothing
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		System.out.println("SessionValidateFilter working.......");

		/*
		 * String returnStr = ""; if (loginMap.containsKey(auth.getName()) ) {
		 * System.out.println(" UserID Exist > " + auth.getName()); if
		 * (request.getSession().getId().equals(loginMap.get(auth.getName()))) {
		 * returnStr = "success"; System.out.println(" VALID  > "); } else {
		 * returnStr = "invalid"; System.out.println(" INVALID  > "); } } else
		 * if (loginMap.containsValue(request.getSession().getId()) ) {
		 * System.out.println(" SessionID Exist > " + auth.getName()); if
		 * (request.getSession().getId().equals(loginMap.get(auth.getName()))) {
		 * returnStr = "success"; System.out.println(" VALID SESSION > "); }
		 * else { returnStr = "invalid";
		 * System.out.println(" INVALID SESSION > "); } }
		 * System.out.println(auth.getName());
		 * System.out.println(request.getSession().getId());
		 * 
		 * // Set<String> roles =
		 * AuthorityUtils.authorityListToSet(auth.getAuthorities()); // if
		 * (roles.contains("ROLE_USER")) { //
		 * request.getSession().setAttribute("myVale", "myvalue"); // }
		 
		if (auth  != null) {
			if (auth.getName().equals("anonymousUser")) {
				try {
					loginController.loginfailed(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print("session time out > no user");
			} else {
				System.out.print("session ok");
				chain.doFilter(req, res);
			}
		}else{
			chain.doFilter(req, res);
		}
*/
		// chain.doFilter("/loginfailed", res);
		// TODO Auto-generated method stubs
	/*	HttpSession session = request.getSession();
	//	User user = session.getAttribute(arg0);
		if (session.getAttribute("LOGIN_USER")  != null) {
			User user = (User) session.getAttribute("LOGIN_USER");
		if(user==null){
			
			System.out.println("SessionValidateFilter null.......");
		}else{
			System.out.println("SessionValidateFilter ok......");
			chain.doFilter(request, response);
		}
		}else{
			System.out.println("SessionValidateFilter skip......");
			chain.doFilter(request, response);
		}
        */
		
		 HttpSession currentSession = ((HttpServletRequest)req).getSession(false);
		  HttpServletResponse resp = (HttpServletResponse) res;
	        if(currentSession == null)
	        {
	            String ajaxHeader = ((HttpServletRequest) req).getHeader("X-Requested-With");
	          
	            if("XMLHttpRequest".equals(ajaxHeader))
	            {
	            //    logger.info("Ajax call detected, send {} error code", this.customSessionExpiredErrorCode);
	              //  HttpServletResponse resp = (HttpServletResponse) res;
	                resp.sendError(this.customSessionExpiredErrorCode);
	            }
	            else
	            {
	            	chain.doFilter(req, res);
	                // Redirect to login page
	            	System.out.println("SessionValidateFilter ok...11...");
	            }
	        }
	        else
	        {
	        	chain.doFilter(req, res);
	        //	resp.sendRedirect("redirect.jsp"); // Redirect to login page
	        	System.out.println("SessionValidateFilter ok.22.....");
	        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



	
	
}
