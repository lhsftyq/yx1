package com.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.dao.SysPermissionDao;
import com.sys.entity.SysPermissionEntity;
import com.sys.service.SysPermissionService;

@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermissionEntity>
		implements SysPermissionService {
	@Autowired
	private SysPermissionDao sysPermissionDao;

	@Override
	public List<SysPermissionEntity> selectList(long id) {
		// TODO Auto-generated method stub
		return sysPermissionDao.selectList(new QueryWrapper<SysPermissionEntity>().eq("pid", id));
	}

	@Override
	public boolean selectBoolean(String name, String pid) {
		// TODO Auto-generated method stub
		try {
			int i = sysPermissionDao
					.selectCount(new QueryWrapper<SysPermissionEntity>().eq("name", name).eq("pid", pid));
			if (i > 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
