package com.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.dao.SysRolePermissionDao;
import com.sys.entity.SysRolePermissionEntity;
import com.sys.service.SysRolePermissionService;

@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionDao, SysRolePermissionEntity>
		implements SysRolePermissionService {

	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	@Override
	public int saveRolePlist(List<SysRolePermissionEntity> reddemCodeList) {
		// TODO Auto-generated method stub
		return sysRolePermissionDao.saveList(reddemCodeList);
	}

}
