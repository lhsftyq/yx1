package com.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sys.entity.SysUser;

/**
 * @Title: SysUser.java
 * @Package com.sys.entity
 * @Description: 系统用户dao
 * @author linghushaofei
 * @date 2019年2月28日 下午1:18:46
 * @version 1.0.0
 * @Company lh
 * @Copyright (c) 2019
 */

@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

	IPage<SysUser> selectPageVo(IPage<SysUser> page);
}
