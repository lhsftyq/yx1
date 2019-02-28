package com.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utils.PictureCheckCode;

@Controller
@RequestMapping("/front")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	private String username = "lhsftyq";
	private String password = "lhsftyq@1";

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request, ModelAndView mav) {
		logger.info("登录成功");
		mav.setViewName("front/home/index");
		return mav;
	}

	// 访问登录界面
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request, ModelAndView mav) {
		logger.info("访问登录界面");
		mav.setViewName("front/login/login");
		return mav;
	}

	// 退出
	@GetMapping("/exit")
	public String exit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		logger.info("访问登录界面");
		request.getSession().setAttribute("session_token", null);
		redirectAttributes.addFlashAttribute("errorMessage", "用户退出成功");
		return "redirect:/front/login";
	}

	//登录
	@PostMapping("/login")
	public String index(HttpServletRequest request, RedirectAttributes redirectAttributes) {

		logger.info("入参:{" + request.getParameter("username") + "}");
		// 生成图片验证码
		String imageCode = (String) request.getSession().getAttribute("imageCode");
		// 验证验证码
		// if (!imageCode.equals(request.getParameter("imageCode"))) {
		// logger.info("验证码验证错误" + imageCode + "=" + request.getParameter("imageCode"));
		// redirectAttributes.addFlashAttribute("errorMessage", "验证码错误!");
		// return "redirect:/front/login";
		// }
		// 验证用户名
		if (ObjectUtils.isEmpty(request.getParameter("username").trim())) {
			redirectAttributes.addFlashAttribute("errorMessage", "用户名不能为空!");
			return "redirect:/front/login";
		}

		if (!request.getParameter("username").trim().equals(username)) {
			redirectAttributes.addFlashAttribute("errorMessage", "用户不存在!");
			return "redirect:/front/login";
		}

		// 验证密码
		if (ObjectUtils.isEmpty(request.getParameter("password").trim())) {
			redirectAttributes.addFlashAttribute("errorMessage", "密码不能为空!");
			return "redirect:/front/login";
		}

		if (!request.getParameter("password").trim().equals(password)) {
			redirectAttributes.addFlashAttribute("errorMessage", "密码错误!");
			return "redirect:/front/login";
		}

		// 登录成功保持session
		request.getSession().setAttribute("session_token", "123456789");

		return "redirect:/front/index";

	}
    //注册
	@GetMapping("/register")
	public String register() {
		System.out.println("注册");
		return "front/register/register";
	}
   //注册
	@GetMapping("/error")
	public ModelAndView error(@RequestParam(name = "errorCode", required = false) String errorCode,
			@RequestParam(name = "errorMessage", required = false) String errorMessage, ModelAndView mav) {
		logger.info("错误页面入参{errorCode:" + errorCode + ",errorMessage:" + errorMessage + "}");
		mav.addObject("errorCode", errorCode);
		mav.addObject("errorMessage", errorMessage);
		mav.setViewName("front/error/error");
		return mav;
	}
    //验证码 
	@GetMapping("/getcode")
	public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		// 利用图片工具生成图片
		// 第一个参数是生成的验证码，第二个参数是生成的图片
		Object[] objs = PictureCheckCode.createImage();
		// 将验证码存入Session
		session.setAttribute("imageCode", objs[0]);

		// 将图片输出给浏览器
		BufferedImage image = (BufferedImage) objs[1];
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

}
