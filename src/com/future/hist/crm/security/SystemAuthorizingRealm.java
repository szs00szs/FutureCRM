
package com.future.hist.crm.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.UserService;

/**
 * 
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 认证回调函数
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {

		System.out.println("**********************开始验证*****************");
		
		String loginName = (String)authcToken.getPrincipal();
		User user = userService.getUserByLoginName(loginName);
		System.out.println("loginName : " + loginName);
		System.out.println("user.getCredentialsSalt() : " + user.getCredentialsSalt());
		System.out.println("user : " + user);
		
		 //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getLoginName(), //登录名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=loginName+salt
                getName()  //realm name
        );
		return authenticationInfo;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String loginName = (String) principals.getPrimaryPrincipal();
		System.out.println("loginName  :  " + loginName);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		 authorizationInfo.setRoles(userService.findRoles(loginName));
		 System.out.println("userService.findPermissions(loginName) : " + userService.findPermissions(loginName));
		 authorizationInfo.setStringPermissions(userService.findPermissions(loginName));
		return authorizationInfo;
	}

	 @Override
	    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
	        super.clearCachedAuthorizationInfo(principals);
	    }

	    @Override
	    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
	        super.clearCachedAuthenticationInfo(principals);
	    }

	    @Override
	    public void clearCache(PrincipalCollection principals) {
	        super.clearCache(principals);
	    }

	    public void clearAllCachedAuthorizationInfo() {
	        getAuthorizationCache().clear();
	    }

	    public void clearAllCachedAuthenticationInfo() {
	        getAuthenticationCache().clear();
	    }

	    public void clearAllCache() {
	        clearAllCachedAuthenticationInfo();
	        clearAllCachedAuthorizationInfo();
	    }
}
