package com.future.hist.crm.domain.form;

public class UserPwd {

	private Long user_id;
	private String newPassword;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "UserPwd [user_id=" + user_id + ", newPassword=" + newPassword + "]";
	}
}
