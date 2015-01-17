package com.chaos.hecate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaos.hecate.persist.user.model.User;
import com.chaos.hecate.persist.user.service.UserManager;

@Component
public class UserTest extends MainTestCase {
	
	@Autowired
	private UserManager um;
	
	@Test
	public void saveTest() {
		User u = new User();
		u.setMobile("123456789");
		u.setPassword("waiwai");
		um.save(u);
		System.out.println(u.getId());
	}

}
