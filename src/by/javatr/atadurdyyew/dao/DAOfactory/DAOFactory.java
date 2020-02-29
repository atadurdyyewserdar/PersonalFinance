package by.javatr.atadurdyyew.dao.DAOfactory;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.dao.impl.AccountDAOImpl;
import by.javatr.atadurdyyew.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final GenericDAO<Account> accountDAO = new AccountDAOImpl();
    private final GenericDAO<User> userDAO = new UserDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getDAOFactory(){
        return instance;
    }

    public GenericDAO<Account> getAccountDAO(){
        return accountDAO;
    }

    public GenericDAO<User> getUserDAO(){
        return userDAO;
    }
}
