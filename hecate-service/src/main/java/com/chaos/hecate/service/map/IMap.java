package com.chaos.hecate.service.map;

import net.sf.json.JSONObject;

public interface IMap {
	
	/**
	 * 根据地理位置获取POI
	 * @return
	 */
	public JSONObject getPoiByGeocodeingRequest(String longitude, String latitude);

}
