package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void createAccount(Account account) throws ServiceException;

    void deleteAccount(Account account) throws ServiceException;

    void update(Account account) throws ServiceException;

    List<Account> getAll() throws ServiceException;

    BigDecimal getBalance(int id) throws ServiceException;

    Account getMyAccount(int userId) throws ServiceException;
}
