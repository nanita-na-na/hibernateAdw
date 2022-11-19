package com.cursor.hibernateadvanced.services;

import com.cursor.hibernateadvanced.models.Student;
import com.cursor.hibernateadvanced.models.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);

    void addTeacherToGroup(Long teacherId, Long groupId);

    void deleteTeacherFromGroup(Long groupId);

    List<Student> getStudentsForTeacher(Long teacherId);

    int getTeachersGroupCount(Long teacherId);
}
