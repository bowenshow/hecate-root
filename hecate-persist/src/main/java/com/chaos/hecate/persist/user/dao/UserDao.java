package com.chaos.hecate.persist.user.dao;

import java.io.Serializable;

import com.chaos.hecate.persist.user.model.User;
import com.chaos.hecate.utils.persistence.BaseDaoInterface;

public interface UserDao extends BaseDaoInterface<User, Serializable> {
	
	User findByMobile(String mobile);

}
