package com.cursor.hibernateadvanced.rest;

import com.cursor.hibernateadvanced.models.Student;
import com.cursor.hibernateadvanced.models.Teacher;
import com.cursor.hibernateadvanced.services.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "/save")
    public Teacher save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PutMapping(value = "/add/{teacherId}/{groupId}")
    public void addTeacherToGroup(@PathVariable Long teacherId, @PathVariable Long groupId) {
        teacherService.addTeacherToGroup(teacherId, groupId);
    }

    @PutMapping(value = "/delete/{groupId}")
    public void deleteTeacherFromGroup(@PathVariable Long groupId) {
        teacherService.deleteTeacherFromGroup(groupId);
    }

    @GetMapping(value = "/teacher/students/{teacherId}")
    public List<Student> getStudentsForTeacher(@PathVariable Long teacherId) {
        return teacherService.getStudentsForTeacher(teacherId);
    }

    @GetMapping(value = "/count/groups/{teacherId}")
    public int getTeachersGroupCount(@PathVariable Long teacherId) {
        return teacherService.getTeachersGroupCount(teacherId);
    }
}
