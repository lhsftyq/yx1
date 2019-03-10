package com.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysPermissionEntity;

public interface SysPermissionService extends IService<SysPermissionEntity> {

	List<SysPermissionEntity> selectList(long id);

	boolean selectBoolean(String name, String pid);
}
