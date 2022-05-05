package com.hitema.services;

import com.hitema.dao.FactoryHibernate;
import com.hitema.entities.Student;
import com.hitema.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeacherHbnImpl implements TeacherService{

    private static final Logger log = LoggerFactory.getLogger(StudentHbnImpl.class);
    private Session session = FactoryHibernate.getSession();


    @Override
    public List<Teacher> getAll() {
        return session.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher create(Teacher teacher) {
        Transaction tx = session.beginTransaction();
        session.persist(teacher);
        tx.commit();
        return teacher;
    }

    @Override
    public Teacher read(Integer id) {
        return session.get(Teacher.class, id);
    }

    @Override
    public Teacher update(Teacher teacher) {
        Transaction tx = session.beginTransaction();
        session.find(Student.class, teacher.getId());
        session.merge(teacher);
        tx.commit();
        return teacher;
    }

    @Override
    public Boolean delete(Teacher teacher) {
        Transaction tx = session.beginTransaction();
        session.remove(read(teacher.getId()));
        tx.commit();
        return ( read(teacher.getId())==null );
    }
}
