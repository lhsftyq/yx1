package com.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author linghushaofei 处理js请求异常
 */

@ControllerAdvice
public class RestExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8755967564963536929L;

	private Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	/**
	 * 拦截Exception类的异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> exceptionHandler(Exception e) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "9999");
		result.put("respMsg", e.getMessage());
		logger.info("异常处理" + e.getLocalizedMessage());

		return result;
	}

	@ExceptionHandler({UnknownAccountException.class,IncorrectCredentialsException.class})
	@ResponseBody
	public ModelAndView unknownAccountHandler(Exception e) {
		ModelAndView vim = new ModelAndView();
		logger.info("异常处理" + e.getLocalizedMessage());
		vim.addObject("errorCode", "9999");
		vim.addObject("errorMessage", e.getLocalizedMessage());
		vim.setViewName("front/login/login");
		return vim;
	}
}
