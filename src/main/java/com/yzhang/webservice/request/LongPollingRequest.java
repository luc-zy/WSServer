package com.yzhang.webservice.request;

import com.yzhang.webservice.Response;
import com.yzhang.webservice.WSRequest;
import com.yzhang.webservice.response.LongPollingResponse;

/**
 * Created by yzhang on 2017/4/10.
 */
public class LongPollingRequest extends WSRequest {
    public Response getResponse() {
        return new LongPollingResponse();
    }

    public String convertToString() {
        return null;
    }
}
