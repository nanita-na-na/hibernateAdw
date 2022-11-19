package com.cursor.hibernateadvanced.rest;

import com.cursor.hibernateadvanced.models.Student;
import com.cursor.hibernateadvanced.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students/")
public class StudentController {
    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping(value = "/add/{studentId}/{groupId}")
    public void add(@PathVariable Long studentId, @PathVariable Long groupId) {
       studentService.addGroupStudentsToStudent(studentId, groupId);
    }

    @PutMapping(value = "/delete/{studentId}")
    public void deleteStudentFromGroupStudents (@PathVariable Long studentId) {
        studentService.deleteStudentFromGroupStudents(studentId);
    }
}
