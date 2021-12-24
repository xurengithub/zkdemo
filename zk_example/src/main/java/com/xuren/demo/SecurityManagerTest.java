package com.xuren.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessControlException;

/**
 * @author xuren
 * @date 2021/11/22
 */
public class SecurityManagerTest extends SecurityManager{
    @Override
    public void checkRead(String file) {
        if ("java.policy".contains(file)) {
            throw new AccessControlException("cannot read file:" + file);
        }
        super.checkRead(file);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setSecurityManager(new SecurityManagerTest());
        InputStream inputStream = new FileInputStream(new File("java.policy"));
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            System.setSecurityManager(null);
        }
    }
}
