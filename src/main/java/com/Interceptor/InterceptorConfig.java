package com.Interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport  {

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		//添加无需要验证请求路径
		List<String>  list = new ArrayList<>();
		list.add("/front/login");
		list.add("/front/getcode");
		list.add("/front/register");
		list.add("/front/error");
		list.add("/static/**");
		list.add("/sys/**");
		list.add("/favicon.ico");
		registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
		super.addInterceptors(registry);
	}
    
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//addResourceHandler请求路径
		//addResourceLocations 在项目中的资源路径
		//setCacheControl 设置静态资源缓存时间
		registry.addResourceHandler("/favicon.ico","/static/**")//favicon.ico
        .addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}

	//设置默认主页
	@Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("front/home/index");
		registry.addViewController("/error").setViewName("error/error");
		registry.addViewController("/front").setViewName("front/home/index");
		registry.addViewController("/front/").setViewName("front/home/index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}
	
	

	
}
