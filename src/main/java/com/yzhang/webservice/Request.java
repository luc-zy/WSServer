package com.yzhang.webservice;

import org.json.JSONException;

/**
 * Created by yzhang on 2017/4/10.
 */
public interface Request {
    Response getResponse();
    String convertToString();
}
