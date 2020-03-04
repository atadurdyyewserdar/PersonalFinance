package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.DAOfactory.DAOFactory;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.dao.impl.UserDAOImpl;
import by.javatr.atadurdyyew.exception.ControllerException;
import by.javatr.atadurdyyew.exception.DAOException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class ClientServiceImpl implements ClientService {

    @Override
    public void changeLogin(String login) throws ServiceException {

    }

    @Override
    public void changePassword(String password) throws ServiceException {

    }

    @Override
    public boolean logIn(String login, String password) throws ServiceException {
        return false;
    }

    @Override
    public boolean logOut(String login) throws ServiceException {
        return false;
    }

    @Override
    public boolean signUp(String login, String password) throws ServiceException {
        GenericDAO<User> userGenericDAO = DAOFactory.getDAOFactory().getUserDAO();
        User user;
        try {
            user =  new User(login, password);
            userGenericDAO.create(user);
            if (user.getId() == -1){
                throw new ServiceException("Couldn't create user");
            }
        } catch (DAOException e) {
            throw new ServiceException("Couldn't create user", e);
        }
        return true;
    }
}
