package com.personnel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.personnel.entity.UserCheckingInEntity;

@Mapper
public interface UserCheckingInDao extends BaseMapper<UserCheckingInEntity> {
}
