package com.chaos.hecate.persist.user.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaos.hecate.core.AbstractManager;
import com.chaos.hecate.persist.user.dao.UserLoginRecordDao;
import com.chaos.hecate.persist.user.model.User;
import com.chaos.hecate.persist.user.model.UserLoginRecord;
import com.chaos.hecate.utils.persistence.BaseDaoInterface;

@Component
public class UserLoginRecordManager extends AbstractManager<UserLoginRecord> {
	
	@Autowired
	private UserLoginRecordDao ulrd;
	
	@Override
	protected BaseDaoInterface<UserLoginRecord, Serializable> getDao() {
		return ulrd;
	}

	public void recordUserLogin(User u, String device) {
		UserLoginRecord ulr = new UserLoginRecord();
		ulr.setUser(u);
		ulr.setDevice(device);
		ulr.setMobile(u.getMobile());
		this.save(ulr);
	}
}
