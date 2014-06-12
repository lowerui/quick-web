package com.quick.web.entity;

import java.util.Date;

/**
 * 用户实体类
 * @author gerry.zhang
 * @since 2014-5-20
 * userName 登录名
 * password 密码
 * email 邮箱
 * mobile 手机号码
 * lastLoginDate 上次登录时间
 */
public class User extends BaseEntity{
	private static final long serialVersionUID = -6381756463217670120L;
	
	private String loginAccount;
	private String password;
	private String email;
	private String mobile;
	private String userName;
	private Date lastLoginDate;
	
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

}
