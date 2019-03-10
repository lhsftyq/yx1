package com.personnel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_checking_in")
public class UserCheckingInEntity {

	@TableField("id")
	private long id;
	@TableField("user_id")
	private long userId; // 用户ID
	@TableField("user_name")
	private String userName; // 用户名称
	@TableField("work_time")
	private String workTime; // 考勤时间
	@TableField("forenoon")
	private int forenoon; // 上午状态
	@TableField("afternoon")
	private int afternoon;// 下午状态'
	@TableField("status")
	private int status; // 状态
	@TableField("remark")
	private String remark; // 备注/事由

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public int getForenoon() {
		return forenoon;
	}

	public void setForenoon(int forenoon) {
		this.forenoon = forenoon;
	}

	public int getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(int afternoon) {
		this.afternoon = afternoon;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
