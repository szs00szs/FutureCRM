
package com.future.hist.crm.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.future.hist.crm.cache.CacheUtils;
import com.future.hist.crm.dao.PrivilegeMapper;
import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.User;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class UserUtils {

	public static final String CACHE_PRI_LIST = "priList";

	public static final String CACHE_ROLE_LIST = "roleList";
	// private static RoleDao roleDao =
	// SpringContextHolder.getBean(RoleDao.class);
	private static PrivilegeMapper privilegeMapper = SpringContextHolder.getBean(PrivilegeMapper.class);
	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_LOGINNAME_ = "loginName";

	private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache() {
		removeCache(CACHE_PRI_LIST);
		UserUtils.clearCache(getUser());
	}

	/**
	 * 清除指定用户缓存
	 * 
	 * @param user
	 */
	public static void clearCache(User user) {

		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGINNAME_ + user.getLoginName());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGINNAME_ + user);
	}

	/**
	 * 根据name获取用户
	 * 
	 * @param name
	 * @return 取不到返回null
	 */
	public static User get(String name) {

		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_LOGINNAME_ + name);
		if (user == null) {
			user = userMapper.getUserByName(name);
			if (user == null) {
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGINNAME_ + user, user);
		}
		return user;
	}

	/**
	 * 根据loginName获取user对象
	 * 
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName) {
		System.out.println("loginName : "  + loginName);
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_LOGINNAME_ + loginName);

		if (user == null) {
			System.out.println("utils的getByLoginName函数开始执行。。。。。。。。。。。。。。。。。");
			user = userMapper.getUserByLoginName(loginName);
			if (user == null) {
				return null;
			}

			CacheUtils.put(USER_CACHE, USER_CACHE_LOGINNAME_ + user.getLoginName(), user);
		}
		return user;
	}

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {

		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	/**
	 * 获取当前用户的菜单，并且缓存，退出的时候清理缓存
	 * 
	 * @return
	 */
	public static List<Privilege> getPrivilegeList() {
		@SuppressWarnings("unchecked")
		List<Privilege> priList = (List<Privilege>) getCache(CACHE_PRI_LIST);
		if (priList == null) {
			User user = getUser();
			String[] roleids = user.getRoleids();
			 if (roleids[0].equals("1")){
				 priList = privilegeMapper.findAllList(new Privilege());
			 }else{
			 Privilege pri = new Privilege();
			 pri.setRoleid(roleids[0]);
			 priList = privilegeMapper.findByRoleId(pri);
			 }
			putCache(CACHE_PRI_LIST, priList);
		}
		return priList;
	}

	/**
	 * 获取当前授权的Principal
	 * 
	 * @return Principal
	 */
	public static Principal getPrincipal() {
		try {
			Subject subject = SecurityUtils.getSubject();
			System.out.println("subject.getPrincipal() : " + (String) subject.getPrincipal());
			Principal principal = (Principal) subject.getPrincipal();
			String loginName = (String) subject.getPrincipal();
			if (principal != null) {
				return principal;
			}
		} catch (UnavailableSecurityManagerException e) {
			e.printStackTrace();
		} catch (InvalidSessionException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 以下是用户信息缓存
	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}

		} catch (InvalidSessionException e) {

		}
		return null;
	}

	/**
	 * 获取当前授权的对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前用户
	 * 
	 * @return 取不到返回新的空对象
	 */

	public static User getUser() {
		Principal principal = getPrincipal();
		if (principal != null) {
			User user = get(principal.getLoginName());
			if (user != null) {
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象
		return new User();
	}

	public static void putCache(String key, Object value) {

		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {

		getSession().removeAttribute(key);

	}
}
