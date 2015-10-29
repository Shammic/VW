package com.misynss.spring.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.util.Assert;

public class MySessionRegistry implements SessionRegistry {

	
	protected final Log logger = LogFactory.getLog(SessionRegistryImpl.class);

    /** <principal:Object,SessionIdSet> */
    private final Map<Object,Set<String>> principals = Collections.synchronizedMap(new HashMap<Object,Set<String>>());
    /** <sessionId:Object,SessionInformation> */
    private final Map<String, SessionInformation> sessionIds = Collections.synchronizedMap(new HashMap<String, SessionInformation>());
    
    
    
	@Override
	public List<Object> getAllPrincipals() {
 
		   System.out.println(principals);	   
		   System.out.println(principals.toString());
		   System.out.println(principals.values());
		   System.out.println(sessionIds);
		   System.out.println(sessionIds.toString());
		   System.out.println(sessionIds.values());
		   
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		//List<Object> authorityList = new ArrayList<Object>();
		
		List<Object> principalsList = new ArrayList<Object>();
		
		principalsList.add(auth.getPrincipal());

//		for (GrantedAuthority role : auth.getAuthorities()) {
//			// System.out.println(role.getAuthority());
//			authorityList.add(role.getAuthority());
//		}
		// TODO Auto-generated method stub
		  return Arrays.asList(principals.keySet().toArray());
		  
	}

	@Override
	public List<SessionInformation> getAllSessions(Object principal,
			boolean includeExpiredSessions) {
		
		
		final Set<String> sessionsUsedByPrincipal = principals.get(principal);

		if (sessionsUsedByPrincipal == null) {
			return Collections.emptyList();
		}

		List<SessionInformation> list = new ArrayList<SessionInformation>(sessionsUsedByPrincipal.size());

		synchronized (sessionsUsedByPrincipal) {
			for (String sessionId : sessionsUsedByPrincipal) {
				SessionInformation sessionInformation = getSessionInformation(sessionId);

				if (sessionInformation == null) {
					continue;
				}

				if (includeExpiredSessions || !sessionInformation.isExpired()) {
					list.add(sessionInformation);
				}
			}
		}
		return list;
	}

	@Override
	public SessionInformation getSessionInformation(String sessionId) {
		Assert.hasText(sessionId,
				"SessionId required as per interface contract");

		return (SessionInformation) sessionIds.get(sessionId);
	}

	public void onApplicationEvent(SessionDestroyedEvent event) {
		String sessionId = event.getId();
		removeSessionInformation(sessionId);
	}

	@Override
	public void refreshLastRequest(String sessionId) {
		Assert.hasText(sessionId,
				"SessionId required as per interface contract");

		SessionInformation info = getSessionInformation(sessionId);

		if (info != null) {
			info.refreshLastRequest();
		}
	}

	@Override
	public synchronized void registerNewSession(String sessionId,
			Object principal) {
		Assert.hasText(sessionId,
				"SessionId required as per interface contract");
		Assert.notNull(principal,
				"Principal required as per interface contract");

		if (logger.isDebugEnabled()) {
			logger.debug("Registering session " + sessionId
					+ ", for principal " + principal);
		}

		if (getSessionInformation(sessionId) != null) {
			removeSessionInformation(sessionId);
		}

		sessionIds.put(sessionId, new SessionInformation(principal, sessionId,new Date()));

		Set<String> sessionsUsedByPrincipal = principals.get(principal);

		if (sessionsUsedByPrincipal == null) {
			sessionsUsedByPrincipal = Collections
					.synchronizedSet(new HashSet<String>(4));
			principals.put(principal, sessionsUsedByPrincipal);
		}

		sessionsUsedByPrincipal.add(sessionId);

		if (logger.isTraceEnabled()) {
			logger.trace("Sessions used by '" + principal + "' : "
					+ sessionsUsedByPrincipal);
		}
	}

	@Override
	public void removeSessionInformation(String sessionId) {
		Assert.hasText(sessionId,
				"SessionId required as per interface contract");

		SessionInformation info = getSessionInformation(sessionId);

		if (info == null) {
			return;
		}

		if (logger.isTraceEnabled()) {
			logger.debug("Removing session " + sessionId
					+ " from set of registered sessions");
		}

		sessionIds.remove(sessionId);

		Set<String> sessionsUsedByPrincipal = principals.get(info
				.getPrincipal());

		if (sessionsUsedByPrincipal == null) {
			return;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Removing session " + sessionId
					+ " from principal's set of registered sessions");
		}

		synchronized (sessionsUsedByPrincipal) {
			sessionsUsedByPrincipal.remove(sessionId);

			if (sessionsUsedByPrincipal.size() == 0) {
				// No need to keep object in principals Map anymore
				if (logger.isDebugEnabled()) {
					logger.debug("Removing principal " + info.getPrincipal()
							+ " from registry");
				}
				principals.remove(info.getPrincipal());
			}
		}

		if (logger.isTraceEnabled()) {
			logger.trace("Sessions used by '" + info.getPrincipal() + "' : "
					+ sessionsUsedByPrincipal);
		}
	}

}
