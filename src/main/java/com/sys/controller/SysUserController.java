package com.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
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
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sys.entity.ResultMessage;
import com.sys.entity.SysUserEntity;
import com.sys.entity.SysUserRoleEntity;
import com.sys.service.SysUserRoleService;
import com.sys.service.SysUserService;
import com.utils.MD5Utils;

@RestController
@RequestMapping("/sys")
public class SysUserController {
	private Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@GetMapping("/user/userList")
	public ModelAndView userList(ModelAndView view) {
		view.setViewName("sys/user/userList");
		return view;
	}

	@GetMapping("/user/register")
	public ModelAndView register(ModelAndView view) {
		logger.info("进入注册界面");
		view.setViewName("sys/user/register/register");
		return view;
	}

	@PostMapping("/user/register")
	public ResultMessage save(String userName, String userNameId, String orgId, String post, String passWord,
			String status, String mdata, String ddata) {
		String uuid = UUID.randomUUID().toString().substring(0, 19);
		SysUserEntity resultUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		// 完成注册
		SysUserEntity sysUserEntity = new SysUserEntity();
		sysUserEntity.setUserName(userName);
		sysUserEntity.setUserNameId(userNameId);
		sysUserEntity.setOrgId(orgId);
		sysUserEntity.setPost(post);
		sysUserEntity.setPassWord(MD5Utils.encrypt(passWord, uuid));
		sysUserEntity.setStatus(status);
		sysUserEntity.setSalt(uuid);

		int j = sysUserService.sysUserSave(sysUserEntity);
		if (j <= 0) {
			return ResultMessage.resultEntity("9999", "用户注册失败,请重试！", null);
		}
		// 加入角色用户表数据
		List<SysUserRoleEntity> sysUserRoleEntity = new ArrayList<SysUserRoleEntity>();
		String[] rdata = mdata.split(",");
		for (int i = 0; i < rdata.length; i++) {
			SysUserRoleEntity sysUserR = new SysUserRoleEntity();
			sysUserR.setUserId(resultUser.getUserId());
			sysUserR.setRoleId(Integer.parseInt(rdata[i]));
			sysUserRoleEntity.add(sysUserR);
		}
		try {
			int k = sysUserRoleService.saveList(sysUserRoleEntity);
			if (k > 0) {
				return ResultMessage.resultEntity("00", null, null);
			} else {
				return ResultMessage.resultEntity("9999", "用户注册失败", null);
			}
		} catch (Exception e) {
			return ResultMessage.resultEntity("9999", "用户注册失败", null);
		}

	}

	@GetMapping("/user/select")
	public ResultMessage select(@RequestParam(name = "page") int page, @RequestParam(name = "limit") int limit) {
		logger.info("请求查询用户表数据  入参{page:" + page + ",limit:" + limit + "}");
		SysUserEntity sysUser = new SysUserEntity();
		sysUser.setUserId(1);
		IPage<SysUserEntity> iPageS = sysUserService.sysUserSelect(new Page<SysUserEntity>(page, limit), 1);
		return ResultMessage.resultEntity("0", null, iPageS.getTotal(), iPageS.getRecords());
	}

	@GetMapping("/user/update")
	public int updateUser() {
		SysUserEntity sysUser = new SysUserEntity();
		sysUser.setUserId(1);
		sysUser.setCreateTime("20190228142500");
		return sysUserService.sysUserUpdate(sysUser);
	}

}
