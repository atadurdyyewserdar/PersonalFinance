package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.DAOfactory.DAOFactory;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.dao.UserDAO;
import by.javatr.atadurdyyew.exception.DAOException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.AccountService;
import by.javatr.atadurdyyew.service.ClientService;

import java.math.BigDecimal;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public void changeLogin(String login) throws ServiceException {

    }

    @Override
    public void changePassword(String password) throws ServiceException {

    }

    @Override
    public boolean logIn(String login, String password) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        boolean result = false;
        try {
            List<User> userList = userDAO.getAll();
            for (User user : userList) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    result = true;
                }
            }
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public boolean logOut(String login) throws ServiceException {
        return false;
    }

    @Override
    public void signUp(String login, String password) throws ServiceException {
        UserDAO userGenericDAO = DAOFactory.getDAOFactory().getUserDAO();
        User user;
        try {
            if (userGenericDAO.findByLogin(login) != null) {
                throw new ServiceException("User Already exists");
            }
            List<User> userList = userGenericDAO.getAll();
            user = new User(findMaxId(userList) + 1, login, password);
            userGenericDAO.create(user);
            AccountServiceImpl accountService = new AccountServiceImpl();
            accountService.createAccount(new Account(user.getId(), user.getId(), BigDecimal.ZERO));
        } catch (DAOException e) {
            throw new ServiceException("Error creating user", e);
        }
    }

    private int findMaxId(List<User> userList) {
        int max;
        if (userList.size() == 0) {
            max = 0;
        } else {
            max = userList.get(0).getId();
            for (User user : userList) {
                if (user.getId() > max) {
                    max = user.getId();
                }
            }
        }
        return max;
    }
}
