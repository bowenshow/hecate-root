package com.chaos.hecate.service.web.utils;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.chaos.hecate.utils.DateUtils;
import com.chaos.hecate.utils.StringUtil;

public class StringDateConvertor implements Converter<String, Date>{

	public Date convert(String source) {
		if(StringUtil.isNotEmpty(source)){
			return DateUtils.parseDate(source);
		}else{
			return new Date();
		}
		
	}
	
 
}
