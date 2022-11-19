package com.cursor.hibernateadvanced.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupStudents {

    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

    @OneToMany(mappedBy = "groupStudents")
    @JsonManagedReference
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public GroupStudents() {
    }

    public GroupStudents(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    @Override
    public String toString() {
        return "GroupStudents{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
