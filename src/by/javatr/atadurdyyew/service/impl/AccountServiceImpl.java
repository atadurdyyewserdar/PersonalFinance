package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.dao.DAOfactory.DAOFactory;
import by.javatr.atadurdyyew.exception.DAOException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.AccountService;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public void createAccount(Account account) throws ServiceException {
        if (account == null) {
            throw new ServiceException("Account is null");
        }
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        AccountDAO accountDAO = daoFactory.getAccountDAO();
        try {
            accountDAO.create(account);
        } catch (DAOException e) {
            throw new ServiceException("Error while creating account", e);
        }
    }

    @Override
    public void deleteAccount(Account account) throws ServiceException {
        if (account == null) {
            throw new ServiceException("Account is null");
        }
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        try {
            accountDAO.delete(account);
        } catch (DAOException e) {
            throw new ServiceException("Error acquired while deleting account", e);
        }
    }

    @Override
    public void update(Account account) throws ServiceException {
        if (account == null) {
            throw new ServiceException("Account is null");
        }
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        try {
            accountDAO.update(account);
        } catch (DAOException e) {
            throw new ServiceException("Error acquired while updating account", e);
        }
    }

    @Override
    public Iterator<Account> getIteratorAll() throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        List<Account> accountList;
        try {
            accountList = accountDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("Error acquired while getting Iterator to accounts", e);
        }
        return accountList.iterator();
    }

    @Override
    public BigDecimal getBalance(int account_id) throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        BigDecimal balance;
        try {
            Account account = accountDAO.find(account_id);
            balance = account.getBalance();
        } catch (DAOException e) {
            throw new ServiceException("Error acquired while getting balance", e);
        }
        return balance;
    }

    @Override
    public Account getMyAccount(int userId) throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        Account account;
        try {
            account = accountDAO.findByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException("Error acquired while getting account id by user_id", e);
        }
        return account;
    }
}
