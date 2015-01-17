package com.chaos.hecate;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chaos.hecate.utils.PasswordUtil;

public class UtilsTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void passwordTest() {
		String psw = "waiwai";
		System.out.println(PasswordUtil.springSecurityPasswordEncode(psw, ""));
	}

}
