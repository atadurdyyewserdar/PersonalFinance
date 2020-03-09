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
        User user;
        try {
            user = userDAO.findByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    @Override
    public boolean logOut(String login) throws ServiceException {
        if (login == null) {
            throw new ServiceException("login is null");
        }
        return true;
    }

    @Override
    public void signUp(User user) throws ServiceException {
        if (user == null || user.getLogin() == null || user.getPassword() == null) {
            throw new ServiceException("user or login or password is null");
        }
        UserDAO userGenericDAO = DAOFactory.getDAOFactory().getUserDAO();
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        try {
            userGenericDAO.create(user);
            accountDAO.create(new Account(BigDecimal.ZERO, user.getId()));
        } catch (DAOException e) {
            throw new ServiceException("Error creating user", e);
        }
    }
}
