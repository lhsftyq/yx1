package com.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sys.entity.ResultMessage;
import com.sys.entity.SysMenuEntity;
import com.sys.entity.SysPermissionEntity;
import com.sys.service.SysPermissionService;

@RestController
@RequestMapping("/sys/permission")
public class SysPermissionController {
	private Logger logger = LoggerFactory.getLogger(SysPermissionController.class);
	@Autowired
	private SysPermissionService sysPermissionService;

	@GetMapping("/list")
	public ResultMessage permissList() {
		List<SysMenuEntity> l = getMenu_l(0);
		logger.info("获取资源返回数据树:" + l);
		return ResultMessage.resultEntity("0", null, l);
	}

	private List<SysMenuEntity> getMenu_l(long id) {
		List<SysMenuEntity> list = new ArrayList<SysMenuEntity>();
		List<SysPermissionEntity> resultMenu = sysPermissionService.selectList(id);
		if (resultMenu.size() == 0) {
			return list;
		}
		for (SysPermissionEntity result : resultMenu) {
			SysMenuEntity sysMenuEntity = new SysMenuEntity();
			sysMenuEntity.setId(result.getId());
			sysMenuEntity.setLabel(result.getName());
			sysMenuEntity.setSpread("true");
			sysMenuEntity.setChildren(getMenu_l(result.getId()));
			list.add(sysMenuEntity);
		}
		return list;
	}

	@RequestMapping(value = "/getList", produces = "application/json;charset=UTF-8")
	public String permissionList() {
		List<SysPermissionEntity> resultMenu1 = sysPermissionService.list();
		String r = JSON.toJSONString(resultMenu1);
		return r;
	}

	@PostMapping("/save")
	public ResultMessage save(SysPermissionEntity sysPermissionEntity) {
		logger.info("保存资源信息 入参" + sysPermissionEntity.toString() + "");
		// 查询资源名称是否存在
		if (sysPermissionService.selectBoolean(sysPermissionEntity.getName(), sysPermissionEntity.getPid())) {
			int j = sysPermissionService.getBaseMapper().insert(sysPermissionEntity);
			if (j > 0) {
				return ResultMessage.resultEntity("00", "资源添加成功", null);
			}
			return ResultMessage.resultEntity("01", "资源添加失败", null);
		} else {
			return ResultMessage.resultEntity("01", "资源名称重复", null);
		}

	}

	@GetMapping("/menuManagement")
	public ModelAndView menuList(ModelAndView model) {
		model.setViewName("/sys/menu/menuManagement");
		return model;
	}

	@GetMapping("/addMenu")
	public ModelAndView addMenu(ModelAndView model) {
		model.setViewName("/sys/menu/addMenu");
		return model;
	}
}
