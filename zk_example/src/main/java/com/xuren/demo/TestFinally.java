package com.xuren.demo;

import com.xuren.demo.testClass.Person;

public class TestFinally {

    public static void main(String[] args) {
        // 结果不一样
        int a = new TestFinally().returnInt();
        int a2 = new TestFinally().returnInt2();
        System.out.println(new TestFinally().returnReference());
    }

    public int returnInt () {
        int a = 1;
        try {
            a = 2;
        } finally {
            a = a+2;
        }
        return a + 1;
    }

    public int returnInt2 () {
        int a = 1;
        try {
            a = 2;
            return a + 1;
        } finally {
            a = a+2;
        }
    }

    public A returnReference() {
        A a = new A();
        try {
            a.setAge(1);
            a.setName("xuren");
            return a;
        } finally {
            a.setName("xuren2");
        }
    }


    static class A {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
