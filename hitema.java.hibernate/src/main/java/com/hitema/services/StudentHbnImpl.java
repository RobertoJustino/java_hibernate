package com.hitema.services;


import com.hitema.dao.FactoryHibernate;
import com.hitema.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentHbnImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentHbnImpl.class);
    private Session session = FactoryHibernate.getSession();

    @Override
    public List<Student> getAll() {
        return session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student create(Student student) {
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        return student;
    }

    @Override
    public Student read(Integer id) {
        return session.get(Student.class, id);
    }

    @Override
    public Student update(Student student) {
        Transaction tx = session.beginTransaction();
        session.find(Student.class, student.getId());
        session.merge(student);
        tx.commit();
        return student;
    }

    @Override
    public Boolean delete(Student student) {
        Transaction tx = session.beginTransaction();
        session.remove(read(student.getId()));
        tx.commit();
        return ( read(student.getId())==null );
    }
}
