package com.hitema.services;

import com.hitema.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StudentHbnImplTest {

    private static final Logger log = LoggerFactory.getLogger(StudentHbnImplTest.class);
    private StudentService service = new StudentHbnImpl();

    private Student student ;

    @BeforeEach
    void setUp() {
        log.trace("Test if service is READY");
        assertNotNull(service,"Service Student Service NOT Ready");
    }

    @Test
    void getAll() {
        var students = service.getAll();
        log.trace("Total Students found : {}",students.size());
        students.forEach(s->log.trace("{}",s));
    }

    @Test
    void create() {
        log.info("<<<START Create Role>>>>");
        student = new Student();
        student.setLastName("Doe");
        student.setFirstName("John");
        student.setBirthDate(LocalDate.of(2000,01,01));
        student.setEmail("mail@gmail.com");
        student.setGenre("M");
        student.setCursus("JEE");
        var r = service.create(student);
        assertNotNull(r.getId(),"ERROR While Create Role :" +student.getId());
        log.trace("Create OK : {} ",r);
        log.info("<<<END   Create Role>>>>");
    }

    @Test
    void read() {
        Integer id = 2;
        var s = service.read(id);
        var roles = s.getRoles();
        roles.forEach(r->log.trace("{}", r));
        log.trace("Lecture Student id :{}, {}",id,s);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}