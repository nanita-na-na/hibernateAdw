package com.cursor.hibernateadvanced.repository;

import com.cursor.hibernateadvanced.models.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
