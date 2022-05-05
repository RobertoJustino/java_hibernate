package com.hitema.services;

import com.hitema.entities.Role;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(RoleServiceImplTest.class);

    RoleService service = new RoleServiceImpl();
    Role role ;

    @BeforeEach
    void setUp() {
        assertNotNull(service,"Service Role n'est pas Instancié !!!");
    }

    @Test
    @Order(4)
    void findAll() {
        log.info("<<<START find All>>>>");
        service.findAll().forEach(r->log.trace("{}",r));
        log.info("<<<END   find All>>>>");
    }

    @Test
    @Order(0)
    void create() {
        log.info("<<<START Create Role>>>>");
        role = new Role();
        role.setCreationDate(LocalDateTime.now());
        role.setLabel("Rôle JUNIT");
        role.setName("ROLE_JUNIT_TEST");
        var r = service.create(role);
        assertNotNull(r.getId(),"ERROR While Create Role :" +role);
        log.trace("Create OK : {} ",r);
        log.info("<<<END   Create Role>>>>");
    }

    @Test
    @Order(1)
    void read() {
        log.info("<<<START READ by Id>>>>");
        assertNotNull(role,"ERROR While Read Role, empty role !!!");
        var r = service.read(role.getId());
        log.trace("Role read Ok:{}", r);
        var u = r.getUsers();
        u.forEach(p->log.trace("{}", p));
        log.info("<<<END   READ by Id>>>>");
    }

    @Test
    @Order(2)
    void update() {
        log.info("<<<START Update Role>>>>");
        assertNotNull(role,"ERROR While Read Role, empty role !!!");
        var r = service.read(role.getId());
        r.setLabel(r.getLabel()+"----Modified----");
        service.update(r);
        log.trace("Update Ok :{}",r);
        log.info("<<<END   Update Role>>>>");
    }

    @Test
    @Order(3)
    void delete() {
        log.info("<<<START Delete by Id>>>>");
        assertNotNull(role,"ERROR While Read Role, empty role !!!");
        var r = service.read(role.getId());
        assertTrue(service.delete(r),"ERROR While Delete Role, Id : "+r.getId());
        log.trace("Role id : {} deleted",r.getId());
    }
}