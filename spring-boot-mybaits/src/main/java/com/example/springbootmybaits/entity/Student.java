package com.example.springbootmybaits.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;

    private String studentNumber;

    private String name;

    private String studentAge;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge == null ? null : studentAge.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", name=").append(name);
        sb.append(", studentAge=").append(studentAge);
        sb.append("]");
        return sb.toString();
    }
}