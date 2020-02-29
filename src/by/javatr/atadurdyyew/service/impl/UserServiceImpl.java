package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.UserService;

public class UserServiceImpl implements UserService {

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
}
