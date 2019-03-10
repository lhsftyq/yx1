package com.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.dao.SysUserRoleDao;
import com.sys.entity.SysUserRoleEntity;
import com.sys.service.SysUserRoleService;


@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity>
		implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public int saveList(List<SysUserRoleEntity> list) {
		// TODO Auto-generated method stub
		return sysUserRoleDao.saveList(list);
	}

}
