package com.chaos.hecate.persist.location.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.chaos.hecate.persist.user.model.User;
import com.chaos.hecate.utils.JSONUtil2;
import com.chaos.hecate.utils.JSONUtil2Serialization;
import com.chaos.hecate.utils.persistence.IdEntity;

/**
 * 
 * @author Bowen
 *
 */
@Entity
@Table(name = "hecate_location")
@Where(clause="deleted=0")
public class Location extends IdEntity implements Serializable,JSONUtil2Serialization {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private float longitude;
	private float latitude;
	private Date time;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="longitude")
	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Column(name="latitude")
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@Column(name="time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String toJson() {
		return JSONUtil2.objectToJson(this);
	}
}
