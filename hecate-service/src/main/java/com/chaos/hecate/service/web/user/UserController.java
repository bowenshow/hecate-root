package com.chaos.hecate.service.web.user;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaos.hecate.persist.user.model.User;
import com.chaos.hecate.persist.user.service.UserLoginRecordManager;
import com.chaos.hecate.persist.user.service.UserManager;
import com.chaos.hecate.utils.JsonMessageMaker;
import com.chaos.hecate.utils.PasswordUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	private static Log log = LogFactory.getLog(UserController.class);
	
	private static final String MOBILE_NUM = "numero_de_mobile";
	private static final String PASSWORD = "mot_de_pass";
	
	@Autowired
	private UserManager um;
	
	@Autowired
	private UserLoginRecordManager ulrm;
	
	@ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
        String mobile = request.getParameter(MOBILE_NUM);
        
        User u = um.findByMobile(mobile);
        if (null != u) {
        	log.debug("Mobile number is already existed: " + mobile);
        	return JsonMessageMaker.createErrorMsg(10001, "该手机号已注册,请核对!");
		}
        String psw = request.getParameter(PASSWORD);
        
        u = new User();
        u.setMobile(mobile);
        u.setPassword(PasswordUtil.springSecurityPasswordEncode(psw, mobile));
        try {
			u = um.save(u);
			ulrm.recordUserLogin(u, null);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Create user failed: " + e.toString());
			return JsonMessageMaker.createErrorMsg(10002, "注册失败,请稍后再试!");
		}
		return JsonMessageMaker.createErrorMsg(0, u.toJson());
	}

	@ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String login(HttpServletRequest request) {
		try {
	        String mobile = request.getParameter(MOBILE_NUM);
	        User u = um.findByMobile(mobile);
	        if (null == u) {
	        	log.warn("Mobile number is not existed: " + mobile);
	        	return JsonMessageMaker.createErrorMsg(10003, "该手机号码未注册,请核对!");
			}
	        String psw = request.getParameter(PASSWORD);
	        String check = PasswordUtil.springSecurityPasswordEncode(psw, mobile);
	        if (check.equals(u.getPassword())) {
	        	log.debug("User logged in: " + mobile);
	        	ulrm.recordUserLogin(u, null);
	        	return JsonMessageMaker.createErrorMsg(0, u.toJson());
			} else {
				return JsonMessageMaker.createErrorMsg(10004, "登录失败,密码不正确!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonMessageMaker.createErrorMsg(99999, e.toString());
		}
	}
}
