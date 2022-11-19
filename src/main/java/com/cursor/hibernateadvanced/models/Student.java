package com.cursor.hibernateadvanced.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String StudentName;
    private String StudentLastname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "group_id")
    private GroupStudents groupStudents;

    public Student() {
    }

    public Student(String studentName, String studentLastname) {
        StudentName = studentName;
        StudentLastname = studentLastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentLastname() {
        return StudentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        StudentLastname = studentLastname;
    }

    public GroupStudents getGroupStudents() {
        return groupStudents;
    }

    public void setGroupStudents(GroupStudents groupStudents) {
        this.groupStudents = groupStudents;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", StudentName='" + StudentName + '\'' +
                ", StudentLastname='" + StudentLastname + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }
}
