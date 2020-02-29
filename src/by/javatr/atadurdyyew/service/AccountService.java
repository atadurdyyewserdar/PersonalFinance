package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.exception.ServiceException;

public interface AccountService {
    void createAccount(Account account) throws ServiceException;

    void deleteAccount(Account account) throws ServiceException;

    void update(Account account) throws ServiceException;
}
