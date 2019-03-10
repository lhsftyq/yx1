package com.sys.entity;

import java.util.List;

public class SysMenuEntity {

	private long id;
	private String label;
	private String spread;
	private String disabled;
	private List<SysMenuEntity> children;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public List<SysMenuEntity> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenuEntity> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "SysMenuEntity [label=" + label + ", spread=" + spread + ", disabled=" + disabled + ", children="
				+ children + "]";
	}

}
