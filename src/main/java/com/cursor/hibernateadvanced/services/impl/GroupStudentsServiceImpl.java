package com.cursor.hibernateadvanced.services.impl;

import com.cursor.hibernateadvanced.models.GroupStudents;
import com.cursor.hibernateadvanced.repository.GroupStudentsRepository;
import com.cursor.hibernateadvanced.services.GroupStudentsService;
import org.springframework.stereotype.Service;

@Service
public class GroupStudentsServiceImpl implements GroupStudentsService {
    private final GroupStudentsRepository groupStudentsRepository;

    public GroupStudentsServiceImpl(GroupStudentsRepository groupStudentsRepository) {
        this.groupStudentsRepository = groupStudentsRepository;
    }

    @Override
    public GroupStudents save(GroupStudents groupStudents) {
        return groupStudentsRepository.save(groupStudents);
    }
}