package com.sys.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_permission")
public class SysPermissionEntity {

	@TableId(value = "id", type = IdType.INPUT)
	private long id;

	@TableField("pid")
	private String pid;

	@TableField("name")
	private String name;

	@TableField("url")
	private String url;

	@TableField("perms")
	private String perms;

	@TableField("type") // 0菜单 1按钮
	private long type;

	@TableField("icon")
	private String icon;

	@TableField("order_num")
	private long orderNum;

	@TableField(exist = false)
	private List<SysPermissionEntity> listP;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public List<SysPermissionEntity> getListP() {
		return listP;
	}

	public void setListP(List<SysPermissionEntity> listP) {
		this.listP = listP;
	}

	@Override
	public String toString() {
		return "SysPermissionEntity [id=" + id + ", parentId=" + pid + ", name=" + name + ", url=" + url + ", perms="
				+ perms + ", type=" + type + ", icon=" + icon + ", orderNum=" + orderNum + ", listP=" + listP + "]";
	}

}
