package com.yzhang;

import com.yzhang.webservice.Request;
import com.yzhang.webservice.Response;
import com.yzhang.webservice.WSClient;
import com.yzhang.webservice.exception.WebServiceClientException;

/**
 * Created by yzhang on 2017/4/11.
 */
public class WSConnection {
    private WSClient client;

    public WSConnection(String targetIp, int targetPort){
        client = new WSClient(targetIp, targetPort);
    }

    /**
     * 发送一个 WebService 请求
     * @param request
     * @return
     * @throws WebServiceClientException
     */
    public Response sendRequest(Request request) throws WebServiceClientException {
        return client.sendRequest(request);
    }
}
