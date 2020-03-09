package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.dao.DAOfactory.DAOFactory;
import by.javatr.atadurdyyew.exception.DAOException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.AccountService;

import java.math.BigDecimal;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public void createAccount(Account account) throws ServiceException {
        if (account == null){
            throw new ServiceException("Account is null");
        }
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        AccountDAO accountDAO = daoFactory.getAccountDAO();
        try {
            accountDAO.create(account);
        } catch (DAOException e) {
            throw new ServiceException("Error while creating account");
        }
    }

    @Override
    public void deleteAccount(Account account) throws ServiceException {
        if (account == null){
            throw new ServiceException("Account is null");
        }
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        try {
            accountDAO.delete(account);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) throws ServiceException {
        if (account == null){
            throw new ServiceException("Account is null");
        }
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        try {
            accountDAO.update(account);
        } catch (DAOException e) {
            throw new ServiceException("update error Service layer", e);
        }
    }

    @Override
    public List<Account> getAll() throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        List<Account> accountList = null;
        try {
            accountList = accountDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("Error getAll() Service Layer", e);
        }
        return accountList;
    }

    @Override
    public BigDecimal getBalance(int id) throws ServiceException{
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        BigDecimal balance;
        try {
            Account account = accountDAO.findById(id);
            balance = account.getBalance();
        } catch (DAOException e) {
            throw new ServiceException("Error get balance ServiceLayer", e);
        }
        return balance;
    }
}
