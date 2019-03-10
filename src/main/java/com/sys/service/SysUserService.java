package com.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysUserEntity;

public interface SysUserService extends IService<SysUserEntity> {
	
	int sysUserSave(SysUserEntity sysUser);

	int sysUserDelete(SysUserEntity sysUser);

	int sysUserUpdate(SysUserEntity sysUser);

	SysUserEntity sysUserSelectOne(String username) throws Exception;

	IPage<SysUserEntity> sysUserSelect(IPage<SysUserEntity> sysUser , Integer state);
	
	

}
