package com.yzhang;

import org.apache.log4j.Logger;

import java.util.Hashtable;

/**
 * Created by yzhang on 2017/4/11.
 */
public class WSServer {

    private static final Logger logger = Logger.getLogger(WSServer.class);

    private Hashtable<String, WSConnection> connectionPool = new Hashtable<String, WSConnection>();
    private static WSServer instance;
    private static Object lock = new Object();

    private WSServer(){};

    public static WSServer getInstance(){
        if (instance == null){
            synchronized(lock){
                if (instance == null){
                    instance = new WSServer();
                }
            }
        }
        return instance;
    }

    /**
     * 添加一个连接
     * @param targetIp
     * @param targetPort
     * @return
     */
    public WSConnection addConnection(String targetIp, int targetPort){
        WSConnection connection = new WSConnection(targetIp, targetPort);
        this.connectionPool.put(targetIp, connection);
        return connection;
    }

    /**
     * 获取指定连接
     * @param targetIp
     * @return
     */
    public WSConnection getConnection(String targetIp){
        return this.connectionPool.get(targetIp);
    }

    /**
     * 移除一个连接
     * @param targetIp
     * @return
     */
    public boolean removeConnection(String targetIp){
        WSConnection connection= this.connectionPool.remove(targetIp);
        return connection != null;
    }
}
