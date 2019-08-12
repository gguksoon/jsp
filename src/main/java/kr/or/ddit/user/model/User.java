package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private String userId;	// 사용자 아이디
	private String pass;	// 사용자 비밀번호
	private String userNm;	// 사용자 이름
	private String alias;	// 별명
	private Date reg_dt;	// 등록일

	public User() {
		
	}

	public User(String userId, String pass, String userNm, Date reg_dt, String alias) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.userNm = userNm;
		this.reg_dt = reg_dt;
		this.alias = alias;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getReg_dt() {
		return reg_dt;
	}
	
	public String getReg_dt_fmt() {
		logger.debug("getReg_dt_fmt method call");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + ", userNm=" + userNm + ", reg_dt=" + reg_dt + ", alias="
				+ alias + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass)) {
			return true;
		}
		return false;
	}
}
