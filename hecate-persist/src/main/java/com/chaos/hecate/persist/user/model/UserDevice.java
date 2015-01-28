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

@Entity
@Table(name = "hecate_user_devices")
@Where(clause="deleted=0")
public class UserDevice extends IdEntity implements Serializable,JSONUtil2Serialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private String device;
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="device")
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Column(name="uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String toJson() {
		return JSONUtil2.objectToJson(this);
	}

}
