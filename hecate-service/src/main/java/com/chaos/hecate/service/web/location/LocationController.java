package com.chaos.hecate.service.web.location;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaos.hecate.persist.location.model.Location;
import com.chaos.hecate.persist.location.service.LocationManager;
import com.chaos.hecate.persist.user.service.UserManager;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	private static Log log = LogFactory.getLog(LocationController.class);
	
	@Autowired
	private UserManager um;
	
	@Autowired
	private LocationManager lm;
	
	@ResponseBody
    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public void updateLocation(HttpServletRequest request) {
		try {
			String mobile = request.getParameter("mobile");
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			float logit = Float.parseFloat(longitude);
			float lati = Float.parseFloat(latitude);
			
			Location loc = new Location();
			loc.setUser(um.findByMobile(mobile));
			loc.setLongitude(logit);
			loc.setLatitude(lati);
			lm.save(loc);
			
			log.info(String.format("longitude: %s, latitude: %s", longitude, latitude));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
