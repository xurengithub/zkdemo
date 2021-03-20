package com.xuren.demo.exampleidmaker;

import com.xuren.demo.ClientFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

public class IdMaker {
    private CuratorFramework client;
    public void init() {
        client = ClientFactory.createSimple("49.232.215.156:2182");
    }
    public String makeId(String nodeName) {
        String str = createSeqNode(nodeName);
        if(str ==  null) {
            return null;
        }
        int index = str.lastIndexOf(nodeName);
        if(index >= 0) {
            return index < str.length() ? str.substring(index) : "";
        }

        return str;
    }

    private String createSeqNode(String nodeName) {
        try {
            String str = client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(nodeName);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
