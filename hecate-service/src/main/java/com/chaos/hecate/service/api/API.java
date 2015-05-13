package com.chaos.hecate.service.api;

public class API {

	// 百度地图逆地理编码服务接口
	public static String BAIDU_GEOCODE_TO_POI = "http://api.map.baidu.com/geocoder/v2/?ak=%s&callback=renderReverse&location=%s,%s&output=json&pois=1";
}
