package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.exception.DAOException;

import java.util.List;

public class AccountDAOImpl implements GenericDAO<Account> {

    public static final String FILE_PATH = "resources/accounts.txt";

    @Override
    public Account get(Account id) throws DAOException {
        return null;
    }

    @Override
    public List<Account> getAll() throws DAOException {
        return null;
    }

    @Override
    public void update(Account id) throws DAOException {
    }

    @Override
    public void delete(Account id) throws DAOException {
    }

    @Override
    public void create(Account id) throws DAOException {
    }
}
