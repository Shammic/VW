package com.misynss.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.misynss.entity.User;
import com.misynss.manager.UserManager;

public class LoginController extends MultiActionController {

	private UserManager userManager;
	private String downloadPath;

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		List<String> authorityList = new ArrayList<String>();

		for (GrantedAuthority role : auth.getAuthorities()) {
			authorityList.add(role.getAuthority());
		}
		User user = new User();
		ModelAndView modelAndView = new ModelAndView();

		if (auth.getName().equals("anonymousUser")) {
			modelAndView.setViewName("login");
			modelAndView.addObject("error", "Session Timeout");
		} else {
			user = userManager.getUserMgr(auth.getName());
			userManager.reSetAttemptNo(auth.getName());
			HttpSession session = request.getSession(true);
			session.removeAttribute("USR_ROLE");
			session.removeAttribute("USR_PRIVILAGES");
			session.removeAttribute("LOGIN_USER");
			session.setAttribute("USR_ROLE", authorityList.get(0));
			session.setAttribute("USR_PRIVILAGES", authorityList);
			session.setAttribute("LOGIN_USER", user);
			modelAndView.setViewName("index");
		}
		modelAndView.addObject("tm", "");

		return modelAndView;
	}

	public ModelAndView downloadPdf(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("downloadPdf");

		return modelAndView;
	}
	
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int result =0 ;
		String attach_ref = request.getParameter("attach_ref");
		String attach_name = request.getParameter("attach_name");

		System.out.println(request.getParameter("attach_ref"));
		System.out.println(attach_name);
		ServletOutputStream outstr = null;
		FileInputStream fileIn = null;

		try {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + request.getParameter("attach_name"));
			//String path = "download_files\\" + attach_ref +".pdf";
			String path = downloadPath + attach_ref +".pdf";
			File file = new File(path);
			fileIn = new FileInputStream(file);
			outstr = response.getOutputStream();

			byte[] outputByte = new byte[(int) file.length()];
			while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
				outstr.write(outputByte, 0, (int) file.length());
			}
			result = 1;
		} catch (Exception e) {
			System.out.println(e);

			result = 0;
		} finally {
			try {
				fileIn.close();
				outstr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// if (result == 1) {
		// strResult = "success";
		// } else {
		// strResult = "false";
		// }
	}

	public ModelAndView loginfailed(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String error_message = "";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth.getName().equals("anonymousUser")) {
			error_message = "Invalid User name or Password.";
		} else {

		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("error", error_message);
		return modelAndView;
	}

	public String loginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "login";
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		session.removeAttribute("USR_ROLE");
		session.removeAttribute("LOGIN_USER");
		session.removeAttribute("STNO");
		return "login";
	}

	public String sessionExpired(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "sessionExpired";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	
}
