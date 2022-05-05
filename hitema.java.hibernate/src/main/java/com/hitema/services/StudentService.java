package com.hitema.services;


import com.hitema.entities.Student;

import java.util.List;

/**
 * défintion des CRUD (Interface)
 */
public interface StudentService {
    List<Student> getAll();
    Student create(Student student);
    Student read(Integer id);
    Student update(Student student);
    Boolean delete(Student student);
}
