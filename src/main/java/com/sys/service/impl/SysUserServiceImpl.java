package com.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sys.dao.SysUserDao;
import com.sys.entity.SysUserEntity;
import com.sys.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	@Transactional
	public int sysUserSave(SysUserEntity sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.insert(sysUser);
	}

	@Override
	@Transactional
	public int sysUserDelete(SysUserEntity sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.delete(new QueryWrapper<SysUserEntity>().eq("user_id", sysUser.getUserId()));
	}

	@Override
	@Transactional
	public int sysUserUpdate(SysUserEntity sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.update(sysUser, new UpdateWrapper<SysUserEntity>().eq("user_id", sysUser.getUserId()));
	}

	@Override
	public IPage<SysUserEntity> sysUserSelect(IPage<SysUserEntity> sysUser, Integer state) {
		IPage<SysUserEntity> result = null;
		try {
			result = sysUserDao.selectPageVo(sysUser);
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public SysUserEntity sysUserSelectOne(String username) throws Exception {
		// TODO Auto-generated method stub
		return sysUserDao.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
	}

}
