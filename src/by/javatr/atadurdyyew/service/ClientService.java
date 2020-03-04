package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.ServiceException;

public interface ClientService {
    void changeLogin(String login) throws ServiceException;

    void changePassword(String password) throws ServiceException;

    boolean logIn(String login, String password) throws ServiceException;

    boolean logOut(String login) throws ServiceException;

    boolean signUp(String login, String password) throws ServiceException;
}
