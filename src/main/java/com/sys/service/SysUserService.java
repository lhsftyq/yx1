package com.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
	
	int sysUserSave(SysUser sysUser);

	int sysUserDelete(SysUser sysUser);

	int sysUserUpdate(SysUser sysUser);

	IPage<SysUser> sysUserSelect(IPage<SysUser> sysUser , Integer state);
	
	
}
