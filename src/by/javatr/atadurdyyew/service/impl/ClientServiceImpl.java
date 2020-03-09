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
import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public User logIn(String login, String password) throws ServiceException {
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
        return true;
    }

    @Override
    public void signUp(User user) throws ServiceException {
        UserDAO userGenericDAO = DAOFactory.getDAOFactory().getUserDAO();
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        try {
            userGenericDAO.create(user);
            accountDAO.create(new Account(BigDecimal.ZERO, user.getId()));
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
