package com.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
	
	int sysUserSave(SysUser sysUser);

	int sysUserDelete(SysUser sysUser);

	int sysUserUpdate(SysUser sysUser);

	SysUser sysUserSelect(String username) throws Exception;
}
