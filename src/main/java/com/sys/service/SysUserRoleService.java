package com.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysUserRoleEntity;

public interface SysUserRoleService extends IService<SysUserRoleEntity>{
	int saveList(List<SysUserRoleEntity> list);
}
