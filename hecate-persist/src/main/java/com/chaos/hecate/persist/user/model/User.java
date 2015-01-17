package com.chaos.hecate.persist.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.chaos.hecate.utils.JSONUtil2Serialization;
import com.chaos.hecate.utils.persistence.IdEntity;

@Entity
@Table(name = "hecate_users")
@Where(clause="deleted=0")
public class User extends IdEntity implements Serializable,JSONUtil2Serialization{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String mobile;
	private String password;
	private String nickname;
	private String name;
	private String email;
	private String headImgUrl;
	private int sex;
	private Date createTime;
	private Date lastLoginTime;
	
	@Column(name="username")	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="head_img_url")
	public String getHeadImgUrl() {
		return headImgUrl;
	}


	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	@Column(name="sex")
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="last_login_time")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

}
