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

public class OperationServiceImpl implements OperationService {
    @Override
    public boolean addFunds(int accountId, BigDecimal amount, String operationName) throws ServiceException {
        AccountDAO accountDAO = DAOFactory.getDAOFactory().getAccountDAO();
        OperationDAO operationDAO = DAOFactory.getDAOFactory().getOperationDAO();
        boolean result;
        try {
            Account account = accountDAO.findById(accountId);
            if (account == null) {
                result = false;
            } else {
                int id = operationDAO.findMaxId() + 1;
                if (amount.compareTo(BigDecimal.ZERO) < 0) {
                    amount = amount.multiply(new BigDecimal(-1));
                }
                Operation operation = new Operation(id, operationName, amount, accountId);
                operationDAO.create(operation);
                result = true;
            }
        } catch (DAOException e) {
            throw new ServiceException("ServiceException writing Operation to file", e);
        }
        return result;
    }
}
