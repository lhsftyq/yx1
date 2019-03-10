package com.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_role_permission")
public class SysRolePermissionEntity {

	@TableField("id")
	@TableId
	private long id;
	@TableField("role_id")
	private long roleId;
	@TableField("menu_id")
	private long menuId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "SysRolePermissionEntity [id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}

}
