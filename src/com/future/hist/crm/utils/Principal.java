package com.future.hist.crm.utils;

import java.io.Serializable;

import com.future.hist.crm.domain.User;

public class Principal implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String loginName;

	public Principal(User user) {

		String s = user.getName();
		this.loginName = user.getLoginName();
	}

	public String getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSessionid() {
		try {
			return (String) UserUtils.getSession().getId();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", loginName=" + loginName + "]";
	}

}
