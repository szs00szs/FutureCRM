/**
 */
package com.future.hist.crm.service;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.util.Digests;
import com.future.hist.crm.util.Encodes;
import com.future.hist.crm.util.UserUtils;

/**
 * 系统service
 * 
 * @author Administrator
 *
 */
@Service
@Transactional(readOnly = true)
public class SystemService implements InitializingBean {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	public User getUserByLoginName(String account) {

		System.out.println("getUserByLoginName(String loginName)函数执行。。。。。。。");

		User user = UserUtils.getByLoginName(account);

		return user;
	}
	
	public static void updatePasswordById(String id, String loginName, String newPassword) {
		
		User user = UserUtils.getByLoginName(loginName);
		
		if(user!=null){
			user.setPassword(entryptPassword(newPassword));
			OfficeService.updateUser(user);
		}
		
		// 清除用户缓存
		user.setName(loginName);
		
		UserUtils.clearCache(user);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
	}

	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}

	/**
	 * 验证密码
	 * 
	 * @param plainPassword
	 *            明文密码
	 * @param password
	 *            密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}

	public List<Privilege> findAllPrivilege() {
		return UserUtils.getPrivilegeList();
	}

	public void afterPropertiesSet() throws Exception {

	}

}
