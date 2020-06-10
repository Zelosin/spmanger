package com.zelosin.untilJuin.dao.users.info;

import com.zelosin.untilJuin.entities.users.info.LinkedVKAccount;
import com.zelosin.untilJuin.entities.users.info.SPUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
public class LinkedAccountService implements LinkedAccountDAOInter {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public LinkedVKAccount findVKLinkedAccountById(long id){
        return entityManager.unwrap(Session.class).get(LinkedVKAccount.class, id);
    }


}
