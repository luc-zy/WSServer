package com.yzhang.webservice.exception;

import org.apache.axis2.AxisFault;

/**
 * Created by yzhang on 2017/4/10.
 */
public class WebServiceClientException extends Exception {
    public WebServiceClientException(){}
    public WebServiceClientException(String s){
        super(s);
    }
}
