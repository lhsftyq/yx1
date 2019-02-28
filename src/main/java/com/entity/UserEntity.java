package com.entity;

import java.util.List;

public class UserEntity {

	private Long  id ;  //用户id
	private String userName; //用户名称
	private String passWord; //用户密码
	private String createTime; //创建时间
	private String updateTime; //更新时间
	private List<Role> roles; //权限
	private List<Drole> dRoles; //数据权限
}
//管理 ，总 ，行政，部门，个人

//date角色表    //date资源表

