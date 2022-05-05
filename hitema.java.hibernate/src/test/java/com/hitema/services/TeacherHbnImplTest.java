package com.hitema.services;

import com.hitema.entities.Student;
import com.hitema.entities.Teacher;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeacherHbnImplTest {

    private TeacherService service = new TeacherHbnImpl();
    private static final Logger log = LoggerFactory.getLogger(StudentHbnImpl.class);
    private Teacher teacher;

    @Test
    @Order(4)
    void getAll() {
        var teachers = service.getAll();
        log.trace("Total Teachers found : {}",teachers.size());
        teachers.forEach(t->log.trace("{}",t));
    }

    @Test
    @Order(0)
    void create() {
        log.info("<<<START Create Teacher>>>>");
        teacher = new Teacher();
        teacher.setLastName("Doe");
        teacher.setFirstName("John");
        teacher.setBirthDate(LocalDate.of(2000,01,01));
        teacher.setEmail("mail@gmail.com");
        teacher.setGenre("M");
        teacher.setModule("JEE");
        var t = service.create(teacher);
        assertNotNull(t.getId(),"ERROR While Create Role :" +teacher.getId());
        log.trace("Create OK : {} ",t);
        log.info("<<<END   Create Teacher>>>>");
    }

    @Test
    @Order(1)
    void read() {
        assertNotNull(teacher,"ERROR While Read Role, empty role !!!");
        var t = service.read(teacher.getId());
        log.trace("Lecture Teacher id :{}, {}",teacher.getId(),t);
    }

    @Test
    @Order(2)
    void update() {
        log.info("<<<START Update Teacher>>>>");
        assertNotNull(teacher,"ERROR While Read Role, empty role !!!");
        var t = service.read(teacher.getId());
        t.setModule(t.getModule()+"----Modified----");
        service.update(t);
        log.trace("Update Ok :{}",t);
        log.info("<<<END   Update Teacher>>>>");
    }

    @Test
    @Order(3)
    void delete() {
        log.info("<<<START Delete by Id>>>>");
        assertNotNull(teacher,"ERROR While Read Role, empty role !!!");
        var t = service.read(teacher.getId());
        assertTrue(service.delete(t),"ERROR While Delete Role, Id : "+t.getId());
        log.trace("Role id : {} deleted",t.getId());
    }
}