package com.yzhang.webservice;

import org.json.JSONException;

/**
 * Created by yzhang on 2017/4/10.
 */
public interface Response {
    void parseString(String str) throws JSONException;
    int getErrorCode();
}
