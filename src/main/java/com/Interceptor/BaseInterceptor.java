package com.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;


public class BaseInterceptor implements HandlerInterceptor{

	private Logger  logger = LoggerFactory.getLogger(BaseInterceptor.class);
	
	//进入CONTROLLER前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info(request.getRequestURI());
		Object session_token = request.getSession().getAttribute("session_token");
		if(ObjectUtils.isEmpty(session_token)) {
			logger.info("未登录请求,跳转登录页面");
			response.sendRedirect(request.getContextPath()+"/front/login");  
			return false;
		}
		 return true;
	}

	
}
