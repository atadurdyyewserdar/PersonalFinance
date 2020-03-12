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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    @Override
    public boolean operation(Operation operation) throws ServiceException {
        if (operation == null) {
            throw new ServiceException("Operation is null");
        }
        boolean result;
        if (operation.getValue().compareTo(BigDecimal.ZERO) < 0) {
            result = expense(operation);
        } else {
            result = income(operation);
        }
        return result;
    }

    private boolean income(Operation operation) throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        boolean result = false;
        Account account;
        try {
            account = accountDAO.find(operation.getAccountId());
            if (account != null) {
                int id = operationDAO.findMaxId() + 1;
                operation.setId(id);
                operationDAO.create(operation);
                account.setBalance(account.getBalance().add(operation.getValue()));
                accountDAO.update(account);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error income add Service Layer", e);
        }
        return result;
    }

    private boolean expense(Operation operation) throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        boolean result = false;
        Account account;
        try {
            account = accountDAO.find(operation.getAccountId());
            if (account != null && account.getBalance().subtract(operation.getValue().abs()).compareTo(BigDecimal.ZERO) >= 0) {
                int id = operationDAO.findMaxId() + 1;
                operation.setId(id);
                operationDAO.create(operation);
                account.setBalance(account.getBalance().subtract(operation.getValue().abs()));
                accountDAO.update(account);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error income add Service Layer", e);
        }
        return result;
    }

    @Override
    public Iterator<Operation> operationList(int account_id) throws ServiceException {
        List<Operation> operations;
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        List<Operation> resultOperationList = new ArrayList<>();
        try {
            operations = operationDAO.getAll();
            for (Operation operation : operations) {
                if (operation.getAccountId() == account_id) {
                    resultOperationList.add(operation);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return resultOperationList.iterator();
    }

    @Override
    public Iterator<Operation> operationListExpense(int id) throws ServiceException {
        List<Operation> operations;
        List<Operation> resultOperationList = new ArrayList<>();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        try {
            operations = operationDAO.getAll();
            for (Operation operation : operations) {
                if (operation.getAccountId() == id && operation.getValue().compareTo(BigDecimal.ZERO) <= 0) {
                    resultOperationList.add(operation);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return resultOperationList.iterator();
    }

    @Override
    public Iterator<Operation> operationListIncome(int id) throws ServiceException {
        List<Operation> operations, resultOperationList = new ArrayList<>();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        try {
            operations = operationDAO.getAll();
            for (Operation operation : operations) {
                if (operation.getAccountId() == id && operation.getValue().compareTo(BigDecimal.ZERO) > 0) {
                    resultOperationList.add(operation);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException("Error while reading all operations ServiceLayer", e);
        }
        return resultOperationList.iterator();
    }

    @Override
    public boolean deleteOperation(int operation_id) throws ServiceException {
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        boolean result = false;
        try {
            Operation operation = operationDAO.find(operation_id);
            if (operation != null) {
                operationDAO.delete(operation);
                System.out.println("From service: " + operation);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error on deleting operation", e);
        }
        //Result will false if object not found
        return result;
    }


}
