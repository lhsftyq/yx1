package com.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_role")
public class SysRoleEntity {
	@TableField("role_id")
	private long roleId; // 角色ID
	@TableField(exist = false)
	private long id = 0;
	@TableField(exist = false)
	private long pid = 0;
	@TableField("role_name")
	private String roleName; // 角色名称
	@TableField("remark")
	private String roleRemark; // 角色备注
	@TableField("create_user_id")
	private long createUserId; // 创建人ID
	@TableField("create_time")
	private String createTime;// 创建时间

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
