package com.zelosin.untilJuin.dao.users;

import com.zelosin.untilJuin.entities.users.info.SPUser;

public interface UserDAOInter {
     SPUser findUserById(long id);
     SPUser findUserByLogin(String login);
}
