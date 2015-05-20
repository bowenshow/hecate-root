package com.chaos.hecate.service.map.baidu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.chaos.hecate.core.SystemConfig;
import com.chaos.hecate.service.api.API;
import com.chaos.hecate.service.map.IMap;
import com.chaos.hecate.utils.HttpClientUtil;

@Component
public class BaiduMap implements IMap {
	
	private static String GEOCODE_REGEX = "renderReverse&&renderReverse\\((.*)\\)";
	
	private static Log log = LogFactory.getLog(BaiduMap.class);

	@Override
	public JSONObject getPoiByGeocode(String longitude,
			String latitude) {
		String ak = SystemConfig.getProperty("baidumap.ak");
		String url = String.format(API.BAIDU_GEOCODE_TO_POI, ak, latitude, longitude);
		String ret = HttpClientUtil.httpGet(url);
		return JSONObject.fromObject(parsePoi(ret));
	}
	
	private String parsePoi(String input) {
		Pattern p = Pattern.compile(GEOCODE_REGEX);
		Matcher match = p.matcher(input);
		if (match.matches() && match.groupCount() > 0) {
			return match.group(1);
		}
		return input;
	}

	public static void main(String[] args) {
		String test = "renderReverse&&renderReverse(12345)";
		String regex = ".*\\((.*)\\).*";
		Pattern p = Pattern.compile(regex);
		Matcher match = p.matcher(test);
		System.out.println(match.matches());
		System.out.println(match.groupCount());
		System.out.println(match.group(0));
		System.out.println(match.group(1));
		String ret = HttpClientUtil.httpGet("http://api.map.baidu.com/geocoder/v2/?ak=E4805d16520de693a3fe707cdc962045&callback=renderReverse&location=39.983424,116.322987&output=json&pois=1");
		System.out.println(ret);
		match = p.matcher(ret);
		System.out.println(match.matches());
		System.out.println(match.groupCount());
		System.out.println(match.group(0));
		System.out.println(match.group(1));
	}
}
