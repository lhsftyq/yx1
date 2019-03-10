package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.entity.SysRolePermissionEntity;
import com.sys.entity.SysUserRoleEntity;

@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	int saveList(List<SysUserRoleEntity> list);
}
