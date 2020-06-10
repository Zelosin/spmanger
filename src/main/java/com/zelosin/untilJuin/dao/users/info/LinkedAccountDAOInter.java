package com.zelosin.untilJuin.dao.users.info;

import com.zelosin.untilJuin.entities.users.info.LinkedVKAccount;
import com.zelosin.untilJuin.entities.users.info.SPUser;

public interface LinkedAccountDAOInter {
     LinkedVKAccount findVKLinkedAccountById(long id);
}
