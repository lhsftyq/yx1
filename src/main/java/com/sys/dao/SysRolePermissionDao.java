package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.entity.SysRolePermissionEntity;

@Mapper
public interface SysRolePermissionDao extends BaseMapper<SysRolePermissionEntity> {

	int saveList(List<SysRolePermissionEntity> list);
}
