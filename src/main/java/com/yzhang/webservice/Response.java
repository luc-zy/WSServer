package com.yzhang.webservice;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yzhang on 2017/4/10.
 */
public interface Response {
    void parseJson(JSONObject jsonObject) throws JSONException;
    int getErrorCode();
    String getResult();
}
