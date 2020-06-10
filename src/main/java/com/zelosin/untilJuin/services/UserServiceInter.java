package com.zelosin.untilJuin.services;

import com.zelosin.untilJuin.entities.users.info.SPUser;

public interface UserServiceInter {
     SPUser findUserById(long id);
     SPUser findUserByLogin(String login);
}
