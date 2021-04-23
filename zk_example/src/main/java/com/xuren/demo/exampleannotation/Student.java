package com.xuren.demo.exampleannotation;

@CustomDescription(description = "学生")
public class Student extends Person{
    private String studentID;
    public int age = 1;

    public Student() {

    }
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    private void studentPrivate() {

    }
}
