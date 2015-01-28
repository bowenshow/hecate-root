package com.chaos.hecate.persist.user.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.chaos.hecate.core.AbstractManager;
import com.chaos.hecate.persist.user.dao.UserDao;
import com.chaos.hecate.persist.user.model.User;
import com.chaos.hecate.utils.persistence.BaseDaoInterface;

@Component
public class UserManager extends AbstractManager<User> {
	
	@Autowired
	private UserDao userDao;

	@Override
	protected BaseDaoInterface<User, Serializable> getDao() {
		return userDao;
	}

	@Override
	@CachePut(value = "user", key = "'user:'+ #u.mobile", condition = "#u != null")
	public User save(User u) {
		return u;
	}
	
	@Cacheable(value = "user", key = "'user:'+ #mobile", unless = "#result == null")
	public User findByMobile(String mobile) {
		return this.userDao.findByMobile(mobile);
	}
	
	@CachePut(value = "user", key = "'user:'+ #u.mobile", condition = "#u != null")
	public User updateUserCacheByUser(User u) {
		return u;
	}
}
