package by.javatr.atadurdyyew.service.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.dao.DAOfactory.DAOFactory;
import by.javatr.atadurdyyew.dao.OperationDAO;
import by.javatr.atadurdyyew.exception.DAOException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.OperationService;

import java.math.BigDecimal;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    @Override
    public boolean operation(int accountId, BigDecimal amount, String operationName) throws ServiceException {
        boolean result;
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            result = expense(accountId, amount, operationName);
        }
        else{
            result = income(accountId, amount, operationName);
        }
        return result;
    }

    private boolean income(int accountId, BigDecimal amount, String operationName) throws ServiceException{
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        boolean result = false;
        Account account;
        try {
            account = accountDAO.findById(accountId);
            if (account != null) {
                int id = operationDAO.findMaxId() + 1;
                Operation operation = new Operation(id, operationName, amount, accountId);
                operationDAO.create(operation);
                account.setBalance(account.getBalance().add(amount));
                System.out.println(account);
                accountDAO.update(account);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error income add Service Layer", e);
        }
        return result;
    }

    private boolean expense(int accountId, BigDecimal amount, String operationName) throws ServiceException{
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        boolean result = false;
        Account account;
        try {
            account = accountDAO.findById(accountId);
            if (account != null && account.getBalance().subtract(amount.abs()).compareTo(BigDecimal.ZERO) >= 0) {
                int id = operationDAO.findMaxId() + 1;
                Operation operation = new Operation(id, operationName, amount, accountId);
                operationDAO.create(operation);
                account.setBalance(account.getBalance().subtract(amount));
                accountDAO.update(account);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error income add Service Layer", e);
        }
        return result;
    }

    @Override
    public List<Operation> operationList() throws ServiceException {
        List<Operation> operations;
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        try {
            operations = operationDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return operations;
    }
}
