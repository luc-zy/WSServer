package com.yzhang.webservice.entity;

/**
 * Created by yzhang on 2017/4/10.
 */
public class WSConfig {

    private String targetIp;
    private int targetPort;

    public String getTargetEndpoint(){
        return "http://"+ targetIp+ ":"+ targetPort+ "/";
    }

    /************getter and setter************/

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public int getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(int targetPort) {
        this.targetPort = targetPort;
    }
}
