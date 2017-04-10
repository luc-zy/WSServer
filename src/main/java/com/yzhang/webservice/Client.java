package com.yzhang.webservice;

import com.yzhang.webservice.exception.WebServiceClientException;

/**
 * Created by yzhang on 2017/4/10.
 */
public interface Client {
    Response sendRequest(Request req) throws WebServiceClientException;
}
