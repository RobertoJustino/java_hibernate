package com.hitema.services;

import com.hitema.dao.FactoryHibernate;
import com.hitema.entities.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    private Session session = FactoryHibernate.getSession();

    @Override
    public List<Role> findAll() {
        return session.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role create(Role role) {
        Transaction tx = session.beginTransaction();
        session.persist(role);
        tx.commit();
        return role;
    }

    @Override
    public Role read(Integer id) {
        return session.get(Role.class,id);
    }

    @Override
    public Role update(Role role) {
        Transaction tx = session.beginTransaction();
        session.find(Role.class, role.getId());
        session.merge(role);
        tx.commit();
        return role;
    }

    @Override
    public Boolean delete(Role role) {
        Transaction tx = session.beginTransaction();
        session.remove(role);
        tx.commit();
        return (read(role.getId())==null);
    }
}
