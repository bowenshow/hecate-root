package com.chaos.hecate.persist.user.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public User findByMobile(String mobile) {
		return this.userDao.findByMobile(mobile);
	}

}
