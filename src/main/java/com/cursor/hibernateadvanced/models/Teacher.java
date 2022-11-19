package com.cursor.hibernateadvanced.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue

    private Long id;
    private String teacherName;
    private String teacherLastname;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<GroupStudents> groupStudents;

    public Teacher() {
    }

    public Teacher(String teacherName, String teacherLastname) {
        this.teacherName = teacherName;
        this.teacherLastname = teacherLastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }

    public List<GroupStudents> getGroupStudents() {
        return groupStudents;
    }

    public void setGroupStudents(List<GroupStudents> groupStudents) {
        this.groupStudents = groupStudents;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacherLastname='" + teacherLastname + '\'' +
                '}';
    }
}
