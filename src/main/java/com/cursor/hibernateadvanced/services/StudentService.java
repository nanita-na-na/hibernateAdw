package com.cursor.hibernateadvanced.services;

import com.cursor.hibernateadvanced.models.Student;

public interface StudentService {
    Student save(Student student);

    void addGroupStudentsToStudent(Long studentId, Long groupId);

    void deleteStudentFromGroupStudents(Long studentId);
}
