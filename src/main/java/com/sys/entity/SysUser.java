package com.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Title: SysUser.java
 * @Package com.sys.entity
 * @Description:  系统用户实体
 * @author linghushaofei
 * @date 2019年2月28日 下午1:18:46
 * @version 1.0.0
 * @Company lh
 * @Copyright (c) 2019
 */
@TableName("sys_user")
public class SysUser {

	@TableField("user_id")
	private long userId;
	@TableField("username")
	private String userName;
	@TableField("password")
	private String passWord;
	@TableField("salt")
	private String salt;
	@TableField("email")
	private String email;
	@TableField("mobile")
	private String mobile;
	@TableField("status")
	private String status;
	@TableField("dept_id")
	private String deptId;
	@TableField("create_time")
	private String createTime;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
