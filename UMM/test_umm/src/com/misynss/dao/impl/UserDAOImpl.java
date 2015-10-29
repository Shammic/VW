package com.misynss.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.misynss.common.Utility;
import com.misynss.dao.UserDAO;
import com.misynss.dao.entitymapper.PrivilageMapper;
import com.misynss.dao.entitymapper.UserMapper;
import com.misynss.entity.Privilage;
import com.misynss.entity.User;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	int result = 0;

	@Override
	public int insertUser(User user) {

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

		try {

			result = this.jdbcTemplate
					.update("insert into usr_mst (usercode, usr_id, first_name, "
							+ "usr_role_id, password, title, last_name, pw_expry_date, usr_status, email, "
							+ "mobile, com_id, attempt_no, pw_chg_date, first_login,"
							+ " rec_status, input_status, input_usr, input_time, auth_stat1, "
							+ "auth_usr1, auth_time1, auth_stat2, auth_usr2, auth_time2)  SELECT (SELECT MAX(usercode + 1) FROM usr_mst), ?, ?, ?, ?,"
							+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?",
							new Object[] { user.getUsrid(), user.getFirstname(), user.getUser_role_id(),
									user.getPassword(), user.getTitle(), user.getLastname(), user.getPw_ex_date(),
									String.valueOf(user.getUsrstatus()), user.getEmail(), user.getMobile(),
									user.getCompany_id(), user.getAtmpt_no(), user.getPwchg_date(),
									String.valueOf(user.getFirstlogin()), String.valueOf(user.getRec_status()),
									String.valueOf(user.getInput_status()), user.getInput_usr(),
									Utility.sysDate("yyyy-MM-dd hh:mm:ss"),
									String.valueOf(user.getAuth_stat1()), user.getAuth_usr1(), user.getAuth_time1(),
									String.valueOf(user.getAuth_stat2()), user.getAuth_usr2(), user.getAuth_time2() });

			transactionManager.commit(status);
		} catch (Exception e) {
			result = 0;
			logger.error("UserDAOImpl.insertUser() - : " + e);
			transactionManager.rollback(status);
		}
		return result;

	}

	@Override
	public User getUser(String usr_id) {

		User user = new User();

		user = jdbcTemplate
				.queryForObject(
						"SELECT a.*,b.com_name FROM usr_mst a , company_mst b WHERE a.com_id = b.com_id and a.usr_id= ? and NOT a.usr_status='C'",
						new Object[] { usr_id }, new UserMapper());

		return user;
	}

	@Override
	public List<User> getUserList(String sql) {
		String sqlstr = "";
		List<User> userList = new ArrayList<User>();
		if (sql.equals("")) {
			sqlstr = "SELECT a.*,b.com_name FROM usr_mst a , company_mst b WHERE a.com_id = b.com_id and NOT a.usr_status='C'";
		} else {
			sqlstr = "SELECT a.*,b.com_name FROM usr_mst a , company_mst b WHERE a.com_id = b.com_id " + sql
					+ " and NOT a.usr_status='C'";
		}
		userList = jdbcTemplate.query(sqlstr, new UserMapper());

		return userList;
	}

	@Override
	public int delete(String id) {
		result = 0;

		result = this.jdbcTemplate.update("update usr_mst set usr_status ='C' where usr_id=?", new Object[] { id });

		return result;

	}

	@Override
	public int updateUser(User user) {
		result = 0;

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

		try {

			result = this.jdbcTemplate
					.update("update usr_mst set first_name =?, "
							+ "usr_role_id =?, password=?, title=?, last_name=?, usr_status =?, email =?, "
							+ "mobile=?, com_id=?, attempt_no=?, pw_chg_date=?, first_login=?,"
							+ " rec_status = ?, input_status = 'M', input_usr=?, input_time= ? where usr_id=?",
							new Object[] {
									// user.getUsercode(),
									// user.getUsrid(),
									user.getFirstname(), user.getUser_role_id(), user.getPassword(), user.getTitle(),
									user.getLastname(), String.valueOf(user.getUsrstatus()), user.getEmail(),
									user.getMobile(), user.getCompany_id(), user.getAtmpt_no(), user.getPwchg_date(),
									String.valueOf(user.getFirstlogin()), String.valueOf(user.getRec_status()),
									// String.valueOf(user.getInput_status()),
									user.getInput_usr(), Utility.sysDate("yyyy-MM-dd hh:mm:ss") , user.getUsrid() });
			// user.getInput_time()});

			transactionManager.commit(status);
		} catch (Exception e) {
			logger.error("UserDAOImpl.updateUser() - : " + e);
			transactionManager.rollback(status);
		}
		return result;

	}
	
	@Override
	public int updateExrenalUser(User user) {
		result = 0;

		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

		try {

			result = this.jdbcTemplate
					.update("update usr_mst set first_name =?, "
							+ " password=?, title=?, last_name=?, usr_status =?, email =?, "
							+ "mobile=?,  attempt_no=?, pw_chg_date=?, first_login=?,"
							+ " rec_status = ?, input_status = 'M', input_usr=?, input_time= ? where usr_id=?",
							new Object[] {
									// user.getUsercode(),
									// user.getUsrid(),
									user.getFirstname(), user.getPassword(), user.getTitle(),
									user.getLastname(), String.valueOf(user.getUsrstatus()), user.getEmail(),
									user.getMobile(), user.getAtmpt_no(), user.getPwchg_date(),
									String.valueOf(user.getFirstlogin()), String.valueOf(user.getRec_status()),
									// String.valueOf(user.getInput_status()),
									user.getInput_usr(), Utility.sysDate("yyyy-MM-dd hh:mm:ss") , user.getUsrid() });
			// user.getInput_time()});

			transactionManager.commit(status);
		} catch (Exception e) {
			logger.error("UserDAOImpl.updateUser() - : " + e);
			transactionManager.rollback(status);
		}
		return result;

	}

	@Override
	public int updateAttemptNo(String userId) {
		result = this.jdbcTemplate.update("update usr_mst set attempt_no = attempt_no + 1 where usr_id=? ",
				new Object[] { userId });
		return result;
	}

	@Override
	public int reSetAttemptNo(String userId) {
		result = this.jdbcTemplate.update("update usr_mst set attempt_no = 0 , usr_status = 'A' where usr_id=? ",
				new Object[] { userId });
		return result;
	}

	@Override
	public String getUserRole(Integer userRole_id) {

		String strSql = "select usr_authority from user_role_mst where user_role_id = ?";

		String userRole = (String) getJdbcTemplate().queryForObject(strSql, new Object[] { userRole_id }, String.class);

		return userRole;
	}
	
	@Override
	public List<Privilage> getPrivilagesList(Integer userRole_id) {
		
		List<Privilage> privilages =  new ArrayList<Privilage>();
		try {
			String strSql = "SELECT * FROM privilage JOIN role_privilage ON  role_privilage.privilage_id = privilage.privilage_id WHERE role_privilage.user_role_id = ? ";
			privilages = jdbcTemplate.query(strSql,new Object[] { userRole_id }  , new  PrivilageMapper());
		} catch (Exception e) {
			System.out.println("" + e);
		}
		
		return privilages;
	}

	@Override
	public int saveChangePassWord(User user) {
		result = 0;

		result = this.jdbcTemplate.update("update usr_mst set  password=?, pw_chg_date= ? "
				+ ", input_status = 'M', input_usr=?, input_time= ? where usr_id=?", new Object[] {
				user.getPassword(),Utility.sysDate("yyyy-MM-dd hh:mm:ss"), user.getInput_usr(), Utility.sysDate("yyyy-MM-dd hh:mm:ss"),user.getUsrid() });

		return result;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
