package com.zelosin.untilJuin.services;

import com.zelosin.untilJuin.dao.users.UserDAOInter;
import com.zelosin.untilJuin.entities.users.info.SPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private UserDAOInter userDAO;



    @Override
    public SPUser findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public SPUser findUserByLogin(String login){
        return userDAO.findUserByLogin(login);
    }

    @Override
    public void update(SPUser user){
         userDAO.update(user);
    }
}
