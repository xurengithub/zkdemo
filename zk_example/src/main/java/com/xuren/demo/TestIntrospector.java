package com.xuren.demo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class TestIntrospector {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        BeanInfo beanInfo = Introspector.getBeanInfo(A.class);
        A a = new A();
        PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : list) {
           if (descriptor.getName().equals("name")) {
               descriptor.getWriteMethod().invoke(a, "xuren");
           }
        }

    }

    static class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
