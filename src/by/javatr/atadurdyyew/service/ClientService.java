package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.ServiceException;

public interface ClientService {
    User logIn(String login, String password) throws ServiceException;

    boolean logOut(String login) throws ServiceException;

    User signUp(String login, String password) throws ServiceException;
}
