package com.yzhang;

import com.yzhang.request.LongPollingRequest;
import com.yzhang.response.LongPollingResponse;
import com.yzhang.webservice.WSClient;
import com.yzhang.webservice.exception.WebServiceClientException;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class Demo
{
    private static final Logger logger = Logger.getLogger(Demo.class);
    public static void main( String[] args ) {
        LongPollingRequest requestOne = new LongPollingRequest();
        LongPollingResponse response = null;

        //only use WSClient to send a request
        WSClient singleClient = new WSClient("172.16.128.98", 9999);
        try {
            response = (LongPollingResponse) singleClient.sendRequest(requestOne);
        } catch (WebServiceClientException e) {
            logger.error("WebService请求发送失败", e);
        }

        //use WSServer to manage connection and send a request
        LongPollingRequest requestTwo = new LongPollingRequest();
        WSConnection connection = WSServer.getInstance().addConnection("172.16.128.98", 9999);
        try {
            response = (LongPollingResponse) connection.sendRequest(requestTwo);
        } catch (WebServiceClientException e) {
            logger.error("WebService请求发送失败", e);
        }
    }
}
