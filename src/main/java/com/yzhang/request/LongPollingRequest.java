package com.yzhang.request;

import com.yzhang.WSRequest;
import com.yzhang.response.LongPollingResponse;
import com.yzhang.webservice.Response;
import org.json.JSONObject;

/**
 * Created by yzhang on 2017/4/11.
 * 描述一个长轮询请求
 */
public class LongPollingRequest extends WSRequest {
    private static final long DEFAULT_TIMEOUT = 15;

    private String customParam;

    public Response getResponse() {
         return new LongPollingResponse();
    }

    public String convertToString() {
        JSONObject json = new JSONObject();
        json.putOpt("request", "longpolling");
        JSONObject param = new JSONObject();
        param.putOpt("timeout", DEFAULT_TIMEOUT);
        if (customParam !=null) {
            param.putOpt("customParam", customParam);
        }
        json.putOpt("param", param);
        return json.toString();
    }



    /************getter and setter************/

    public String getCustomParam() {
        return customParam;
    }

    public void setCustomParam(String customParam) {
        this.customParam = customParam;
    }
}
