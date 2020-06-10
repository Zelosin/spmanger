package com.zelosin.untilJuin.dao.users;

import com.zelosin.untilJuin.entities.users.info.SPUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
public class UserDAOImpl implements UserDAOInter {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public SPUser findUserById(long id){
        Session session  = entityManager.unwrap(Session.class);
        return session.get(SPUser.class, id);
    }

    @Transactional
    public SPUser findUserByLogin(String login){
        Session session  = entityManager.unwrap(Session.class);
        return (SPUser) session.createQuery("from SPUser where userName="+login).list().get(0);
    }

}
