package com.yzhang.webservice;

import com.yzhang.webservice.entity.WSConfig;
import com.yzhang.webservice.exception.WebServiceClientException;
import com.yzhang.webservice.external.GwslibStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.log4j.Logger;
import org.json.JSONException;

import java.rmi.RemoteException;


/**
 * Created by yzhang on 2017/4/9.
 */
public class WSClient implements Client{
    private static final Logger logger = Logger.getLogger(WSClient.class);
    private static final long TIMEOUT = 15000;
    private WSConfig config;

    public WSClient(String targetIp, int targetPort){
        config = new WSConfig();
        config.setTargetIp(targetIp);
        config.setTargetPort(targetPort);
    }

    public Response sendRequest(Request request) throws WebServiceClientException {
        String req = request.convertToString();
        logger.info("<< WSClient发送>> -----> "+ req);

        GwslibStub.DoCommand cmd = new GwslibStub.DoCommand();
        cmd.setStrXMLReq(req);
        GwslibStub stub;
        GwslibStub.DoCommandResponse res;
        try {
            stub = getGwslibStub();
            Options opts = stub._getServiceClient().getOptions();
            opts.setTimeOutInMilliSeconds(TIMEOUT);
            res = stub.doCommand(cmd);
        } catch (AxisFault axisFault) {
            logger.error("AxisFault", axisFault);
            throw new WebServiceClientException("连接刻录机服务失败："+ config.getTargetEndpoint());
        } catch (RemoteException e) {
            logger.error("RemoteException", e);
            throw new WebServiceClientException("连接刻录机服务失败："+ config.getTargetEndpoint());
        } catch (Exception e){
            logger.error("UnknownException", e);
            throw new WebServiceClientException("连接刻录机服务失败："+ config.getTargetEndpoint());
        }

        String ret = res.getStrResp();
        logger.info("<<WSClient接收>> <----- "+ ret);
        Response response = request.getResponse();
        try{
            response.parseString(ret);
        } catch (JSONException e) {
            logger.error("JSONException", e);
            throw new WebServiceClientException("解析返回结果错误："+ config.getTargetEndpoint());
        }
        int errorCode = response.getErrorCode();
        if (errorCode> 0){
            throw new WebServiceClientException("远端返回错误码："+ errorCode);
        }
        return response;
    }

    /**
     * 获取远程调用接口
     * @return
     * @throws AxisFault
     */
    private GwslibStub getGwslibStub() throws AxisFault{
        GwslibStub stub = new GwslibStub(config.getTargetEndpoint());
        return stub;
    }

    /************getter and setter************/

//    public WSConfig getConfig() {
//        return config;
//    }
//
//    public void setConfig(WSConfig config) {
//        this.config = config;
//    }
}
