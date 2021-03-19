package com.xuren.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ClientFactory {
    public static CuratorFramework createSimple(String connectStr) {
        return CuratorFrameworkFactory.newClient(connectStr, new ExponentialBackoffRetry(1000, 3));
    }

    public static CuratorFramework createWithOptions(String connectStr, int sessionTimeOut, int connectTimeOut, RetryPolicy retryPolicy) {
        return CuratorFrameworkFactory.builder()
                .sessionTimeoutMs(sessionTimeOut)
                .connectionTimeoutMs(connectTimeOut)
                .connectString(connectStr)
                .retryPolicy(retryPolicy)
                .build();
    }
}
