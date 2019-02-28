package com.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.dao.SysUserDao;
import com.sys.entity.SysUser;
import com.sys.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService{

	@Override
	public int sysUserSave(SysUser sysUser) {
		// TODO Auto-generated method stub
		return baseMapper.insert(sysUser);
	}

	@Override
	public int sysUserDelete(SysUser sysUser) {
		// TODO Auto-generated method stub
		return baseMapper.delete(new QueryWrapper<SysUser>().eq("user_id",sysUser.getUserId()));
	}

	@Override
	public int sysUserUpdate(SysUser sysUser) {
		// TODO Auto-generated method stub
		return baseMapper.update(sysUser, new UpdateWrapper<SysUser>().eq("user_id",sysUser.getUserId()));
	}

	@Override
	public SysUser sysUserSelect(SysUser sysUser) {
		// TODO Auto-generated method stub
		return baseMapper.selectOne(new QueryWrapper<SysUser>().eq("user_id",sysUser.getUserId()));
	}

}
