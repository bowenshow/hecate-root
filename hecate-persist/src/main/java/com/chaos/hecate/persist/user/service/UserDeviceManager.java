package com.chaos.hecate.persist.user.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaos.hecate.core.AbstractManager;
import com.chaos.hecate.persist.user.dao.UserDeviceDao;
import com.chaos.hecate.persist.user.model.UserDevice;
import com.chaos.hecate.utils.persistence.BaseDaoInterface;

@Component
public class UserDeviceManager extends AbstractManager<UserDevice> {
	
	@Autowired
	private UserDeviceDao userDeviceDao;

	@Override
	protected BaseDaoInterface<UserDevice, Serializable> getDao() {
		return userDeviceDao;
	}
	
}
