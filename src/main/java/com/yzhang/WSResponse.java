package com.yzhang;

import com.yzhang.webservice.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yzhang on 2017/4/11.
 */
public abstract class WSResponse implements Response{
    private String result;
    private int errorCode;
    public void parseJson(JSONObject jsonObject) throws JSONException {
        try{
            errorCode = jsonObject.getInt("errorCode");
            result = jsonObject.getString("result");
        }catch (NullPointerException e){
            throw new JSONException("未找到指定字段 errorCode或 result", e);
        }
    }


    public int getErrorCode() {
        return errorCode;
    }

    public String getResult() {
        if (result == null) result = "还为收到返回结果";
        return result;
    }
}
