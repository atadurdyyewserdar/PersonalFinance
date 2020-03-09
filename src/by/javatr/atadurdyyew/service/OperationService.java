package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface OperationService {
    boolean operation(int accountId, BigDecimal amount, String operationName) throws ServiceException;
    List<Operation> operationList() throws ServiceException;
}
