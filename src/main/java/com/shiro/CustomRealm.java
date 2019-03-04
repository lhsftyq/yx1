package com.shiro;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.sys.entity.SysUser;
import com.sys.service.SysUserService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;

	// 设置权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取前端输入的用户信息，封装为User对象
//		SysUser userweb = (SysUser) principals.getPrimaryPrincipal();
		
		System.out.println("11111111111111111111111111");
		
        //获取前端输入的用户名
//        String username = userweb.getUserName();
        //根据前端输入的用户名查询数据库中对应的记录
//        resultSysUser = sysUserService.sysUserSelect(username);
        //如果数据库中有该用户名对应的记录，就进行授权操作
//        if (user != null){
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            //因为addRoles和addStringPermissions方法需要的参数类型是Collection
//            //所以先创建两个collection集合
//            Collection<String> rolesCollection = new HashSet<String>();
//            Collection<String> perStringCollection = new HashSet<String>();
//            //获取user的Role的set集合
//            Set<Role> roles = user.getRoles();
//            //遍历集合
//            for (Role role : roles){
//                //将每一个role的name装进collection集合
//                rolesCollection.add(role.getName());
//                //获取每一个Role的permission的set集合
//                Set<Permission> permissionSet =  role.getPermissions();
//                //遍历集合
//                for (Permission permission : permissionSet){
//                    //将每一个permission的name装进collection集合
//                    perStringCollection.add(permission.getName());
//                }
//                //为用户授权
//                info.addStringPermissions(perStringCollection);
//            }
//            //为用户授予角色
//            info.addRoles(rolesCollection);
//            return info;
//        }else{
            return null;
//        }
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 取得用户名
		String username = (String) token.getPrincipal();
		SysUser sysUser = new SysUser();
		sysUser.setUserName(username);
		SysUser resultSysUser = null;
		try {
			resultSysUser = sysUserService.sysUserSelect(username);
		} catch (Exception e) {
			throw new UnknownAccountException("数据库异常,请联系管理员!");
		}
		if (ObjectUtils.isEmpty(resultSysUser)) {
			throw new UnknownAccountException("该用户不存在!");
		}
		ByteSource credentialsSalt = ByteSource.Util.bytes(resultSysUser.getSalt());
		String password = new String((char[]) token.getCredentials());
//		if (resultSysUser.getPassWord().equals(password)) {
			AuthenticationInfo auth = new SimpleAuthenticationInfo(resultSysUser, password, credentialsSalt,
					"CustomRealm");
			return auth;
//		} else {
//			throw new IncorrectCredentialsException("密码错误！");
//		}
	}
}
