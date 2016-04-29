package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.User;

public interface SystemService  {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	public User getUserByLoginName(String loginName);
	
	public void updatePasswordById(String id, String loginName, String newPassword);

	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public String entryptPassword(String plainPassword);

	/**
	 * 验证密码
	 * 
	 * @param plainPassword
	 *            明文密码
	 * @param password
	 *            密文密码
	 * @return 验证成功返回true
	 */
	public boolean validatePassword(String plainPassword, String password);

	public List<Privilege> findAllPrivilege();

	public void afterPropertiesSet() throws Exception;

}
