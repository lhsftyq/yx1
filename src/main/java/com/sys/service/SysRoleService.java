package com.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysRoleEntity;
import com.sys.entity.SysUserEntity;

public interface SysRoleService extends IService<SysRoleEntity> {
	// 获取用户角色信息
	IPage<SysRoleEntity> sysRoleSelectPage(IPage<SysRoleEntity> sysRoleEntity, Long currentUserId);

	// 获取全部角色信息
	IPage<SysRoleEntity> sysRoleSelectPageList(IPage<SysRoleEntity> sysRoleEntity);

	List<SysRoleEntity> sysRoleSelect(long state);

	SysRoleEntity selectOneRole(String roleName);
	
	boolean  delRole(long id);
}
