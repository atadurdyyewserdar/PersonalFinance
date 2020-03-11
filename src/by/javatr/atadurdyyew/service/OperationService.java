package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Iterator;

public interface OperationService {
    boolean operation(int accountId, BigDecimal amount, String operationName) throws ServiceException;

    Iterator<Operation> operationList(int account_id) throws ServiceException;

    Iterator<Operation> operationListExpense(int account_id) throws ServiceException;

    Iterator<Operation> operationListIncome(int account_id) throws ServiceException;

    boolean deleteOperation(int operation_id) throws ServiceException;
}
