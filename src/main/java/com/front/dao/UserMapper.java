package com.front.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-02-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
