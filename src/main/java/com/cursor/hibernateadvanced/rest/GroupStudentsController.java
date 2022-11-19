package com.cursor.hibernateadvanced.rest;

import com.cursor.hibernateadvanced.models.GroupStudents;
import com.cursor.hibernateadvanced.models.Student;
import com.cursor.hibernateadvanced.services.GroupStudentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/groups/")
public class GroupStudentsController {

    private final GroupStudentsService groupStudentsService;

    public GroupStudentsController(GroupStudentsService groupStudentsService) {
        this.groupStudentsService = groupStudentsService;
    }

    @PostMapping(value = "/save")
    public GroupStudents save(@RequestBody GroupStudents groupStudents) {
        return groupStudentsService.save(groupStudents);
    }
}
