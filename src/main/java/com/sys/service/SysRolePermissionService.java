package com.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysRolePermissionEntity;

public interface SysRolePermissionService extends IService<SysRolePermissionEntity> {

	int saveRolePlist(List<SysRolePermissionEntity> reddemCodeList);
}
