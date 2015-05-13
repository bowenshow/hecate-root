package com.chaos.hecate.service.map.baidu;

import net.sf.json.JSONObject;

import com.chaos.hecate.core.SystemConfig;
import com.chaos.hecate.service.api.API;
import com.chaos.hecate.service.map.IMap;
import com.chaos.hecate.utils.HttpClientUtil;

public class BaiduMap implements IMap {

	@Override
	public JSONObject getPoiByGeocodeingRequest(String longitude,
			String latitude) {
		String ak = SystemConfig.getProperty("baidumap.ak");
		String url = String.format(API.BAIDU_GEOCODE_TO_POI, ak, latitude, longitude);
		String ret = HttpClientUtil.httpGet(url);
		return JSONObject.fromObject(ret);
	}


}
