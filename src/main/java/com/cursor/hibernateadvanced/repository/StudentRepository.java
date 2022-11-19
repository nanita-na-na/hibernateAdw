package com.cursor.hibernateadvanced.repository;

import com.cursor.hibernateadvanced.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
