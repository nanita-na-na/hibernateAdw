package com.cursor.hibernateadvanced.services.impl;

import com.cursor.hibernateadvanced.models.GroupStudents;
import com.cursor.hibernateadvanced.models.Student;
import com.cursor.hibernateadvanced.models.Teacher;
import com.cursor.hibernateadvanced.repository.GroupStudentsRepository;
import com.cursor.hibernateadvanced.repository.TeacherRepository;
import com.cursor.hibernateadvanced.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final GroupStudentsRepository groupStudentsRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, GroupStudentsRepository groupStudentsRepository) {
        this.teacherRepository = teacherRepository;
        this.groupStudentsRepository = groupStudentsRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void addTeacherToGroup(Long teacherId, Long groupId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        GroupStudents groupStudents = groupStudentsRepository.findById(groupId).get();

        groupStudents.setTeacher(teacher);
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherFromGroup(Long groupId) {
        GroupStudents groupStudents = groupStudentsRepository.findById(groupId).get();
        groupStudents.setTeacher(null);
        groupStudentsRepository.save(groupStudents);
    }

    @Override
    public List<Student> getStudentsForTeacher(Long teacherId) {
        List<Student> students = new ArrayList<>();
        for (GroupStudents groupStudents : teacherRepository.findById(5L).get().getGroupStudents()) {
            students.addAll(groupStudents.getStudents().stream().toList());
        }
        return students;
    }

    @Override
    public int getTeachersGroupCount(Long teacherId) {
        return teacherRepository.findById(5L).get().getGroupStudents().size();
    }
}
