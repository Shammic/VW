package com.misynss.entity;

import java.util.List;

public class User {

	private int usercode = 0;
	private String usrid = ""; // varchar
	private int user_role_id = 0;
	private String title = ""; // varchar
	private String firstname = ""; // varchar
	private String lastname = ""; // varchar
	private String password = ""; // varchar
	private String pw_ex_date = "1900-01-01"; // date = "1900-01-01" ; // date
	private String email = ""; // varchar
	private String mobile = ""; // varchar
	private int company_id = 0; // intr
	private char usrstatus = 'X';// char
	private int atmpt_no = 0; // int
	private String pwchg_date = "1900-01-01 00:00:00"; // date = "1900-01-01" ;
														// // date
	private char firstlogin = 'Y'; // char
	private char rec_status = 'X';
	private char input_status = 'I'; // char
	private String input_usr = ""; // varchar
	private String input_time = "1900-01-01 00:00:00"; // datetime
	private char auth_stat1 = 'P'; // char
	private String auth_usr1 = ""; // varchar
	private String auth_time1 = "1900-01-01 00:00:00"; // datetime
	private char auth_stat2 = 'P'; // char
	private String auth_usr2 = ""; // varchar
	private String auth_time2 = "1900-01-01 00:00:00"; // datetime
	private List<Privilage> privilageList ;

	private String company_name = ""; //
	private String user_status = "";

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPw_ex_date() {
		return pw_ex_date;
	}

	public void setPw_ex_date(String pw_ex_date) {
		this.pw_ex_date = pw_ex_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public char getUsrstatus() {
		return usrstatus;
	}

	public void setUsrstatus(char usrstatus) {
		this.usrstatus = usrstatus;
	}

	public int getAtmpt_no() {
		return atmpt_no;
	}

	public void setAtmpt_no(int atmpt_no) {
		this.atmpt_no = atmpt_no;
	}

	public String getPwchg_date() {
		return pwchg_date;
	}

	public void setPwchg_date(String pwchg_date) {
		this.pwchg_date = pwchg_date;
	}

	public char getFirstlogin() {
		return firstlogin;
	}

	public void setFirstlogin(char firstlogin) {
		this.firstlogin = firstlogin;
	}

	public char getRec_status() {
		return rec_status;
	}

	public void setRec_status(char rec_status) {
		this.rec_status = rec_status;
	}

	public char getInput_status() {
		return input_status;
	}

	public void setInput_status(char input_status) {
		this.input_status = input_status;
	}

	public String getInput_usr() {
		return input_usr;
	}

	public void setInput_usr(String input_usr) {
		this.input_usr = input_usr;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public char getAuth_stat1() {
		return auth_stat1;
	}

	public void setAuth_stat1(char auth_stat1) {
		this.auth_stat1 = auth_stat1;
	}

	public String getAuth_usr1() {
		return auth_usr1;
	}

	public void setAuth_usr1(String auth_usr1) {
		this.auth_usr1 = auth_usr1;
	}

	public String getAuth_time1() {
		return auth_time1;
	}

	public void setAuth_time1(String auth_time1) {
		this.auth_time1 = auth_time1;
	}

	public char getAuth_stat2() {
		return auth_stat2;
	}

	public void setAuth_stat2(char auth_stat2) {
		this.auth_stat2 = auth_stat2;
	}

	public String getAuth_usr2() {
		return auth_usr2;
	}

	public void setAuth_usr2(String auth_usr2) {
		this.auth_usr2 = auth_usr2;
	}

	public String getAuth_time2() {
		return auth_time2;
	}

	public void setAuth_time2(String auth_time2) {
		this.auth_time2 = auth_time2;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getUser_status() {
		if (usrstatus == 'A') {
			user_status = "Active";
		} else if (usrstatus == 'X') {
			user_status = "Default";
		} else if (usrstatus == 'D') {
			user_status = "Delete";
		} else if (usrstatus == 'L') {
			user_status = "Lock";
		}
		return user_status;
	}

	public void setUser_status(char usrstatus) {
		String user_status = "";
		if (usrstatus == 'A') {
			user_status = "Active";
		} else if (usrstatus == 'X') {
			user_status = "Default";
		} else if (usrstatus == 'D') {
			user_status = "Delete";
		} else if (usrstatus == 'L') {
			user_status = "Lock";
		}
		this.user_status = user_status;
	}

	public List<Privilage> getPrivilageList() {
		return privilageList;
	}

	public void setPrivilageList(List<Privilage> privilageList) {
		this.privilageList = privilageList;
	}

	
}
