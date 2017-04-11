package com.yzhang.response;

import com.yzhang.WSResponse;
import org.json.JSONException;

/**
 * Created by yzhang on 2017/4/11.
 * 描述一个长轮询请求的返回值
 */
public class LongPollingResponse extends WSResponse {
    public void parseString(String str) throws JSONException {

    }

    public int getErrorCode() {
        return 0;
    }
}
