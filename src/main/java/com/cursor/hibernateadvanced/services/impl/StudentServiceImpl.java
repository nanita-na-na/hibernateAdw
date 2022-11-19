package com.cursor.hibernateadvanced.services.impl;

import com.cursor.hibernateadvanced.models.GroupStudents;
import com.cursor.hibernateadvanced.models.Student;
import com.cursor.hibernateadvanced.repository.GroupStudentsRepository;
import com.cursor.hibernateadvanced.repository.StudentRepository;
import com.cursor.hibernateadvanced.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupStudentsRepository groupStudentsRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GroupStudentsRepository groupStudentsRepository) {
        this.studentRepository = studentRepository;
        this.groupStudentsRepository = groupStudentsRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void addGroupStudentsToStudent(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).get();
        GroupStudents group = groupStudentsRepository.findById(groupId).get();

        student.setGroupStudents(group);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentFromGroupStudents(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        student.setGroupStudents(null);
        studentRepository.save(student);
    }
}