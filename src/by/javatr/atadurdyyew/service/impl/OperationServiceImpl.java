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
import java.util.Iterator;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    @Override
    public boolean operation(int accountId, BigDecimal amount, String operationName) throws ServiceException {
        if (amount == null || operationName == null) {
            throw new ServiceException("Amount or operationName is null");
        }
        boolean result;
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            result = expense(accountId, amount, operationName);
        } else {
            result = income(accountId, amount, operationName);
        }
        return result;
    }

    private boolean income(int accountId, BigDecimal amount, String operationName) throws ServiceException {
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
                accountDAO.update(account);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error income add Service Layer", e);
        }
        return result;
    }

    private boolean expense(int accountId, BigDecimal amount, String operationName) throws ServiceException {
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
                account.setBalance(account.getBalance().subtract(amount.abs()));
                accountDAO.update(account);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error income add Service Layer", e);
        }
        return result;
    }

    @Override
    public Iterator<Operation> operationList() throws ServiceException {
        List<Operation> operations;
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        try {
            operations = operationDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return operations.iterator();
    }

    @Override
    public Iterator<Operation> operationListExpense(int id) throws ServiceException {
        List<Operation> operations;
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        try {
            operations = operationDAO.getAll();
            for (Operation operation : operations){
                if (operation.getValue().compareTo(BigDecimal.ZERO) >= 0 ){
                    operations.remove(operation);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return operations.iterator();
    }

    @Override
    public Iterator<Operation> operationListIncome(int id) throws ServiceException {
        List<Operation> operations;
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        try {
            operations = operationDAO.getAll();
            for (Operation operation : operations){
                if (operation.getValue().compareTo(BigDecimal.ZERO) < 0){
                    operations.remove(operation);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return operations.iterator();
    }
}
