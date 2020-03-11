package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.exception.DAOException;

public interface AccountDAO extends CRUD<Account> {
    Account findByUserId(int id) throws DAOException;
}
