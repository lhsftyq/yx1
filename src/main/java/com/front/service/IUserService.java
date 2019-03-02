package com.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-02-28
 */
public interface IUserService extends IService<User> {
	User queryByMobile();
}
