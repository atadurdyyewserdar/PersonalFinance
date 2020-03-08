package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.DAOException;

public interface AccountDAO extends GenericDAO<Account>{
    Account findByUserId(int id) throws DAOException;
}
