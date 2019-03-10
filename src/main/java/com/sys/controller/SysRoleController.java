package com.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.entity.ResultMessage;
import com.sys.entity.SysMenuEntity;
import com.sys.entity.SysPermissionEntity;
import com.sys.entity.SysRoleEntity;
import com.sys.entity.SysRolePermissionEntity;
import com.sys.entity.SysUserEntity;
import com.sys.service.SysRolePermissionService;
import com.sys.service.SysRoleService;
import com.utils.DateUtils;

@RestController
@RequestMapping("/sys")
public class SysRoleController {
	private Logger logger = LoggerFactory.getLogger(SysRoleController.class);

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysRolePermissionService sysRolePermissionService;

	@GetMapping("/user/role")
	public ModelAndView role(ModelAndView view) {
		logger.info("进入角色管理界面");
		view.setViewName("sys/role/role");
		return view;
	}

	@GetMapping("/addRole")
	public ModelAndView addRole(ModelAndView view) {
		logger.info("进入角色管理界面");
		view.setViewName("sys/role/addRole");
		return view;
	}

	// 保存用户权限信息
	@PostMapping("/user/roleSave")
	public ResultMessage userRoleSave(@RequestParam(name = "roleName") String roleName,
			@RequestParam(name = "roleRemark") String roleRemark, @RequestParam(name = "mdata") String mdata,
			@RequestParam(name = "ddata") String ddata) {
		logger.info("保存用户权限信息 入参{" + mdata + "}");
		SysUserEntity resultUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		// 查询角色名称是否重复
		SysRoleEntity sysRoleEntity_r = sysRoleService.selectOneRole(roleName);
		if (!ObjectUtils.isEmpty(sysRoleEntity_r)) {
			return ResultMessage.resultEntity("9999", "角色名称已存在", null);
		}
		// 将角色ID和资源ID保存 角色资源表
		SysRoleEntity sysRoleEntity = new SysRoleEntity();
		sysRoleEntity.setRoleName(roleName);
		sysRoleEntity.setRoleRemark(roleRemark);
		sysRoleEntity.setCreateUserId(0);// resultUser.getUserId()
		sysRoleEntity.setCreateTime(DateUtils.getFormatTime(new Date()));
		// 保存
		try {
			sysRoleService.getBaseMapper().insert(sysRoleEntity);
		} catch (Exception e) {
			logger.info("保存角色数据异常");
		}
		// 查询数据是否保存成功,并获取ID号
		SysRoleEntity sysRoleEntity_r1 = sysRoleService.selectOneRole(roleName);
		if (ObjectUtils.isEmpty(sysRoleEntity_r1)) {
			return ResultMessage.resultEntity("9999", "角色未保存成功,请重试!", null);
		}

		// 获取出资源明细
		List<SysRolePermissionEntity> rList = new ArrayList<SysRolePermissionEntity>();
		String[] mdataList = mdata.split(",");
		for (int i = 0; i < mdataList.length; i++) {
			SysRolePermissionEntity sysRoleP = new SysRolePermissionEntity();
			sysRoleP.setRoleId(sysRoleEntity_r1.getRoleId());
			sysRoleP.setMenuId(Integer.parseInt(mdataList[i]));
			rList.add(sysRoleP);
		}
		// 将角色ID 角色名称 角色备注 保存 角色表
		try {
			int j = sysRolePermissionService.saveRolePlist(rList);
			if (j == 0) {
				// 删除角色
				sysRoleService.delRole(sysRoleEntity_r1.getRoleId());
				return ResultMessage.resultEntity("9999", "角色添加失败!", null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			// 删除角色
			sysRoleService.delRole(sysRoleEntity_r1.getRoleId());
			return ResultMessage.resultEntity("9999", "角色添加失败!", null);
		}
		return ResultMessage.resultEntity("0", "角色添加成功!", null);
	}

	// 查询权限列表
	@GetMapping("/user/roleList")
	public ResultMessage userRoleList(@RequestParam(name = "page") int page, @RequestParam(name = "limit") int limit) {
		logger.info("请求查询用户表数据  入参{page:" + page + ",limit:" + limit + "}");
		SysUserEntity resultUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		logger.info("当前用户" + resultUser.getUserId());
		IPage<SysRoleEntity> iPageS = sysRoleService.sysRoleSelectPage(new Page<SysRoleEntity>(page, limit),
				resultUser.getUserId());
		return ResultMessage.resultEntity("0", null, iPageS.getTotal(), iPageS.getRecords());
	}

	// 查询权限列表
	@GetMapping("/roleList")
	public ResultMessage roleList(@RequestParam(name = "page") int page, @RequestParam(name = "limit") int limit) {
		logger.info("请求查询用户表数据  入参{page:" + page + ",limit:" + limit + "}");
		IPage<SysRoleEntity> iPageS = null;
		try {
			iPageS = sysRoleService.sysRoleSelectPageList(new Page<SysRoleEntity>(page, limit));
			logger.info("" + iPageS.hashCode());
		} catch (Exception e) {
			logger.error("访问角色表数据异常");
			return ResultMessage.resultEntity("0", null, 0, null);
		}
		return ResultMessage.resultEntity("0", null, iPageS.getTotal(), iPageS.getRecords());
	}

	@GetMapping(value = "/getList")
	public ResultMessage roleList() {
		List<SysMenuEntity> list = new ArrayList<SysMenuEntity>();
		List<SysRoleEntity> resultMenu1 = sysRoleService.list();
		for (int i = 0; i < resultMenu1.size(); i++) {
			SysMenuEntity sysMenuEntity = new SysMenuEntity();
			sysMenuEntity.setChildren(null);
			sysMenuEntity.setId(resultMenu1.get(i).getRoleId());
			sysMenuEntity.setLabel(resultMenu1.get(i).getRoleName());
			sysMenuEntity.setSpread("true");
			list.add(sysMenuEntity);
		}
		return ResultMessage.resultEntity("0", null, list);
	}

}
