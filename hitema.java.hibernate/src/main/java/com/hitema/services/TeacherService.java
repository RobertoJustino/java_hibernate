package com.hitema.services;

import com.hitema.entities.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAll();
    Teacher create(Teacher teacher);
    Teacher read(Integer id);
    Teacher update(Teacher teacher);
    Boolean delete(Teacher teacher);
}
