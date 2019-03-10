package com.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.dao.SysRoleDao;
import com.sys.entity.SysRoleEntity;
import com.sys.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public IPage<SysRoleEntity> sysRoleSelectPage(IPage<SysRoleEntity> sysRoleEntity, Long state) {
		// TODO Auto-generated method stub
		return sysRoleDao.selectPage(sysRoleEntity, new QueryWrapper<SysRoleEntity>().inSql("role_id",
				"select role_id from `sys_user_role` where user_id = " + state + ""));
	}

	@Override
	public List<SysRoleEntity> sysRoleSelect(long state) {
		return sysRoleDao.selectList(new QueryWrapper<SysRoleEntity>().apply(
				"select e.* from  `sys_user_role` r inner join `sys_role` e on r.role_id = e.role_id  where r.user_id = "
						+ state + ""));
	}

	@Override
	public IPage<SysRoleEntity> sysRoleSelectPageList(IPage<SysRoleEntity> sysRoleEntity) {
		// TODO Auto-generated method stub
		return sysRoleDao.selectPage(sysRoleEntity, new QueryWrapper<SysRoleEntity>());
	}

	@Override
	public SysRoleEntity selectOneRole(String roleName) {
		// TODO Auto-generated method stub
		return sysRoleDao.selectOne(new QueryWrapper<SysRoleEntity>().eq("role_name", roleName));
	}

	@Override
	@Transactional
	public boolean delRole(long id) {
		// TODO Auto-generated method stub
		int j = sysRoleDao.delete(new UpdateWrapper<SysRoleEntity>().eq("role_id", id));
		if (j > 0) {
			return true;
		}
		return false;
	}

}
