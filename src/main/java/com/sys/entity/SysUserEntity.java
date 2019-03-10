package com.sys.entity;

import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Title: SysUser.java
 * @Package com.sys.entity
 * @Description: 系统用户实体
 * @author linghushaofei
 * @date 2019年2月28日 下午1:18:46
 * @version 1.0.0
 * @Company lh
 * @Copyright (c) 2019
 */
@TableName("sys_user")
public class SysUserEntity {

	@TableField("user_id")
	private long userId; // id
	@TableField("username")
	private String userName; // 账号
	@TableField("user_name_id")
	private String userNameId;// 员工名称
	@TableField("password")
	private String passWord;// 密码
	@TableField("salt")
	private String salt; // 盐
	@TableField("email")
	private String email; // 邮箱
	@TableField("mobile")
	private String mobile; // 电话
	@TableField("status")
	private String status; // 状态
	@TableField("dept_id")
	private String deptId; // 创建ID
	@TableField("create_time")
	private String createTime; // 创建时间
	@TableField("orgId")
	private String orgId; // 所属部门
	@TableField("post")
	private String post; // 职位
	@TableField(exist = false)
	private String jdata;
	@TableField(exist = false)
	private String ddata;

	@TableField(exist = false)
	private Set<SysRoleEntity> roles; // 角色数值

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

	public Set<SysRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRoleEntity> roles) {
		this.roles = roles;
	}

	public String getUserNameId() {
		return userNameId;
	}

	public void setUserNameId(String userNameId) {
		this.userNameId = userNameId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getJdata() {
		return jdata;
	}

	public void setJdata(String jdata) {
		this.jdata = jdata;
	}

	public String getDdata() {
		return ddata;
	}

	public void setDdata(String ddata) {
		this.ddata = ddata;
	}

	@Override
	public String toString() {
		return "SysUserEntity [userId=" + userId + ", userName=" + userName + ", userNameId=" + userNameId
				+ ", passWord=" + passWord + ", salt=" + salt + ", email=" + email + ", mobile=" + mobile + ", status="
				+ status + ", deptId=" + deptId + ", createTime=" + createTime + ", orgId=" + orgId + ", post=" + post
				+ ", jdata=" + jdata + ", ddata=" + ddata + ", roles=" + roles + "]";
	}

}
