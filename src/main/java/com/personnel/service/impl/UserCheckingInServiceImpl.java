package com.personnel.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personnel.dao.UserCheckingInDao;
import com.personnel.entity.UserCheckingInEntity;
import com.personnel.service.UserCheckingInService;
import com.sys.dao.SysRolePermissionDao;
import com.sys.entity.SysRolePermissionEntity;
import com.sys.service.SysRolePermissionService;

@Service("userCheckingInService")
public class UserCheckingInServiceImpl extends ServiceImpl<UserCheckingInDao, UserCheckingInEntity> implements UserCheckingInService {


}
