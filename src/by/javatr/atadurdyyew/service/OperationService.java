package by.javatr.atadurdyyew.service;

import by.javatr.atadurdyyew.exception.ServiceException;

import java.math.BigDecimal;

public interface OperationService {
    boolean operation(int accountId, BigDecimal amount, String operationName) throws ServiceException;
}
