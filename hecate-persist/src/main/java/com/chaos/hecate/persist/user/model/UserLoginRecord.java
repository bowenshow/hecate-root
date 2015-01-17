package com.chaos.hecate.persist.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.chaos.hecate.utils.JSONUtil2;
import com.chaos.hecate.utils.JSONUtil2Serialization;
import com.chaos.hecate.utils.persistence.IdEntity;

/**
 * 用户登录记录
 * @author Bowen
 *
 */
@Entity
@Table(name = "hecate_user_login")
@Where(clause="deleted=0")
public class UserLoginRecord extends IdEntity implements Serializable,JSONUtil2Serialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;			// 用户
	private String mobile;		// 手机号
	private String device;		// 用户使用设备，ios，Android，etc
	private String time;		// 登录时间
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="user_mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="login_device")
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Column(name="login_time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toJson() {
		return JSONUtil2.objectToJson(this);
	}

}
