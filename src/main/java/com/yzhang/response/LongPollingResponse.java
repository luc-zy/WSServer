package com.yzhang.response;

import com.yzhang.WSResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yzhang on 2017/4/11.
 * 描述一个长轮询请求的返回值
 */
public class LongPollingResponse extends WSResponse {
    private String customParam;
    public void parseJson(JSONObject jsonObject) throws JSONException {
        super.parseJson(jsonObject);
        try{
            JSONObject param = jsonObject.getJSONObject("param");
            customParam = param.getString("customParam");
        }catch (NullPointerException e){
            throw new JSONException("未找到指定字段 customParam", e);
        }
    }


    public String getCustomParam() {
        return customParam;
    }
}
