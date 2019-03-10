//package com.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.front.service.IUserService;
//import com.sys.entity.User;
//
///**
// * <p>
// * 前端控制器
// * </p>
// *
// * @author jobob
// * @since 2019-02-28
// */
//@RestController
//@RequestMapping("/com/user")
//public class UserController {
//
//	@Autowired
//	private IUserService iUserService;
//
//	@GetMapping("/test")
//	public User test() {
//		return iUserService.queryByMobile();
//	}
//}
