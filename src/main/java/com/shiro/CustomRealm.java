package com.shiro;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sys.entity.SysPermissionEntity;
import com.sys.entity.SysRoleEntity;
import com.sys.entity.SysUserEntity;
import com.sys.service.SysPermissionService;
import com.sys.service.SysRoleService;
import com.sys.service.SysUserService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysPermissionService sysPermissionService;

	// 设置权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取前端输入的用户信息，封装为User对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		SysUserEntity userweb = (SysUserEntity) principals.getPrimaryPrincipal();
		List<SysRoleEntity> roles = sysRoleService.getBaseMapper().selectList(new QueryWrapper<SysRoleEntity>().apply(
				"select e.* from  `sys_user_role` r inner join `sys_role` e on r.role_id = e.role_id  where r.user_id = "
						+ userweb.getUserId() + ""));
		if (userweb != null) {
			Collection<String> rolesCollection = new HashSet<String>();
			Collection<String> perStringCollection = new HashSet<String>();
			// 遍历集合
			for (SysRoleEntity role : roles) {
				rolesCollection.add(role.getRoleName());
			}

			List<SysPermissionEntity> permissionSet = sysPermissionService.getBaseMapper()
					.selectList(new QueryWrapper<SysPermissionEntity>().apply(
							"select * from `sys_permission` u inner join (select k.menu_id from `sys_role_menu` k inner join ( select e.* from `sys_user_role` r inner join `sys_role` e on r.role_id ="
									+ "e.role_id where r.user_id = " + userweb.getUserId()
									+ " ) g on k.role_id = g.role_id group by k.menu_id) m on u.menu_id = m.menu_id"));
			for (SysPermissionEntity permission : permissionSet) {
				// 将每一个permission的name装进collection集合
				perStringCollection.add(permission.getName());
			}
			// 为用户授予角色
			info.addRoles(rolesCollection);
			// 为用户授权
			info.addStringPermissions(perStringCollection);
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 取得用户名
		String username = (String) token.getPrincipal();
		SysUserEntity sysUser = new SysUserEntity();
		sysUser.setUserName(username);
		SysUserEntity resultSysUser = null;
		try {
			resultSysUser = sysUserService.sysUserSelectOne(username);
		} catch (Exception e) {
			throw new UnknownAccountException("数据库异常,请联系管理员!");
		}
		if (ObjectUtils.isEmpty(resultSysUser)) {
			throw new UnknownAccountException("该用户不存在!");
		}
		
		if(resultSysUser.getStatus() == "2") {
			throw new UnknownAccountException("该用户已禁用,请联系管理员!");
		}
		
		ByteSource credentialsSalt = ByteSource.Util.bytes(resultSysUser.getSalt());
		AuthenticationInfo auth = new SimpleAuthenticationInfo(resultSysUser, resultSysUser.getPassWord(),
				credentialsSalt, "myShiroRealm");
		return auth;
	}
}
