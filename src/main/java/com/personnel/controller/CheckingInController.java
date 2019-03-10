package com.personnel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sys.entity.ResultMessage;

@RestController
@RequestMapping("/checking")
public class CheckingInController {

	// 员工登录只能查看自己的考勤信息
	// 部门领导登录可以查询本部门考勤信息
	// 公司领导及考勤人员可以查询全部员工考勤信息

	// 考勤人员：
	// 1、录入考勤信息 时间、状态、备注 。 状态关联请假表 如状态修改为调休则修改请假表信息，抵消一天请假信息。

	// 跳转考勤表查看
	public void checkingIn() {
		// 获取人员权限
	}

	// 跳转考勤表可以编辑
	@GetMapping("/edit")
	public ModelAndView checkingInEdit(ModelAndView model) {
		// 获取需要考勤人员的名单

		// 获取考勤信息
		model.setViewName("/sys/clocking_in/clocking-in");
		return model;
	}

	@GetMapping("/userCheckingInList")
	public ResultMessage userCheckingInList(@RequestParam(name = "dateTimeStat")String dateTimeStat,@RequestParam(name = "dateTimeEnd")String dateTimeEnd) {

		System.out.println("dateTimeStat"+dateTimeStat+"___dateTimeEnd:"+dateTimeEnd);
		
		//获取员工名称，时间段内考勤正常天数，缺勤天数，请假天数，调休天数，外勤天数
		return ResultMessage.resultEntity("0", "成功", 0, null);
	}
}
