package com.chaos.hecate.utils;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDateConvertor implements Converter<String, Date>{

	public Date convert(String source) {
		if(StringUtil.isNotEmpty(source)){
			return DateUtils.parseDate(source);
		}else{
			return new Date();
		}
		
	}
}
