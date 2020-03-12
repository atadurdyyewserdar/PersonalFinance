package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.dao.DAOfactory.DAOFactory;
import by.javatr.atadurdyyew.dao.UserDAO;
import by.javatr.atadurdyyew.exception.DAOException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;

import java.math.BigDecimal;

public class ClientServiceImpl implements ClientService {

    @Override
    public User logIn(String login, String password) throws ServiceException {
        if (login == null || password == null) {
            throw new ServiceException("Login or password is null");
        }
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        User result;
        try {
            result = userDAO.findByLogin(login);
            if (result != null && !result.getPassword().equals(password)) {
                result = null;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error acquired while logging in", e);
        }
        return result;
    }

    @Override
    public boolean logOut(String login) throws ServiceException {
        if (login == null) {
            throw new ServiceException("login is null");
        }
        return true;
    }

    @Override
    public User signUp(String login, String password) throws ServiceException {
        if (login == null || password == null) {
            throw new ServiceException("user is null");
        }
        UserDAO userGenericDAO = DAOFactory.getDAOFactory().getUserDAO();
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        User user = null;
        try {
            if (userGenericDAO.findByLogin(login) == null) { //If login valid then create new User
                user = new User(login, password);
                userGenericDAO.create(user);
                Account account = new Account();
                account.setBalance(BigDecimal.ZERO);
                account.setUserId(user.getId());
                accountDAO.create(account);
            }
        } catch (DAOException e) {
            throw new ServiceException("Error creating user", e);
        }
        return user;
    }
}
