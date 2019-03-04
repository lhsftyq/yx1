package com.sys.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.front.dao.UserMapper;
import com.sys.dao.SysUserDao;
import com.sys.entity.SysUser;
import com.sys.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	@Transactional
	public int sysUserSave(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.insert(sysUser);
	}

	@Override
	@Transactional
	public int sysUserDelete(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.delete(new QueryWrapper<SysUser>().eq("user_id", sysUser.getUserId()));
	}

	@Override
	@Transactional
	public int sysUserUpdate(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.update(sysUser, new UpdateWrapper<SysUser>().eq("user_id", sysUser.getUserId()));
	}

	@Override
	public IPage<SysUser> sysUserSelect(IPage<SysUser> sysUser, Integer state) {
		IPage<SysUser> result = null;
		try {
			result = sysUserDao.selectPageVo(sysUser);
		} catch (Exception e) {
		}

		return result;

	}

	@Override
	public SysUser sysUserSelectOne(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
