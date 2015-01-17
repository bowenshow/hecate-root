package com.chaos.hecate.utils;

import net.sf.json.JSONObject;

public class JsonMessageMaker {
	
    public static JSONObject createErrorMsg(int errcode, String errmsg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errcode", errcode);
        jsonObject.put("errmsg", errmsg);
        return jsonObject;
    }

}
