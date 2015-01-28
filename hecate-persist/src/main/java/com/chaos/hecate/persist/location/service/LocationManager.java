package com.chaos.hecate.persist.location.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaos.hecate.core.AbstractManager;
import com.chaos.hecate.persist.location.dao.LocationDao;
import com.chaos.hecate.persist.location.model.Location;
import com.chaos.hecate.utils.persistence.BaseDaoInterface;

/**
 * 
 * @author Bowen
 *
 */
@Component
public class LocationManager extends AbstractManager<Location> {
	
	@Autowired
	private LocationDao locationDao;

	@Override
	protected BaseDaoInterface<Location, Serializable> getDao() {
		return locationDao;
	}

}
