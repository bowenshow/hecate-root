package com.chaos.hecate.utils;

import net.sf.json.JSONObject;

public class JsonMessageMaker {
	
    public static String createErrorMsg(int errcode, String errmsg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errcode", errcode);
        jsonObject.put("errmsg", errmsg);
        return jsonObject.toString();
    }

}
