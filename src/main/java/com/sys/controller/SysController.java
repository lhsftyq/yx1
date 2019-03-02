package com.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.entity.ResultEntity;
import com.sys.entity.SysUser;
import com.sys.service.SysUserService;

@RestController
@RequestMapping("/sys")
public class SysController {
	private Logger logger = LoggerFactory.getLogger(SysController.class);
	@Autowired
	private SysUserService sysUserService;

	@GetMapping("/user/userList")
	public ModelAndView userList(ModelAndView view) {
		view.setViewName("sys/user/userList");
		return view;
	}

	@GetMapping("/user/register")
	public int save() {
		SysUser sysUser = new SysUser();
		sysUser.setDeptId("1");
		sysUser.setCreateTime("2019-02-28 14:04:11");
		sysUser.setEmail("371121962@qq.com");
		sysUser.setMobile("15985176085");
		sysUser.setPassWord("12345678");
		sysUser.setSalt("000");
		sysUser.setStatus("0");
		sysUser.setUserId(0);
		sysUser.setUserName("linghushaofei");

		return sysUserService.sysUserSave(sysUser);
	}

	@GetMapping("/user/select")
	public ResultEntity select(@RequestParam(name = "page") int page, @RequestParam(name = "limit") int limit) {
		logger.info("请求查询用户表数据  入参{page:" + page + ",limit:" + limit + "}");
		SysUser sysUser = new SysUser();
		sysUser.setUserId(1);
		IPage<SysUser> iPageS = sysUserService.sysUserSelect(new Page<SysUser>(page, limit), 1);
		return ResultEntity.resultEntity("0", null, iPageS.getTotal(), iPageS.getRecords());
	}

	@GetMapping("/user/update")
	public int updateUser() {
		SysUser sysUser = new SysUser();
		sysUser.setUserId(1);
		sysUser.setCreateTime("20190228142500");
		return sysUserService.sysUserUpdate(sysUser);
	}

}
