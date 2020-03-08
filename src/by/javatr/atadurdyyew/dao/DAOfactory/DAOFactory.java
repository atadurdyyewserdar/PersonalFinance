package by.javatr.atadurdyyew.dao.DAOfactory;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.dao.UserDAO;
import by.javatr.atadurdyyew.dao.impl.AccountDAOImpl;
import by.javatr.atadurdyyew.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final AccountDAO accountDAO = new AccountDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getDAOFactory(){
        return instance;
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }
}
