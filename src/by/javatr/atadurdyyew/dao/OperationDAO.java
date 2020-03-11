package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.exception.DAOException;

public interface OperationDAO extends CRUD<Operation> {
    Operation findByType(boolean isExpense) throws DAOException;
    int findMaxId() throws DAOException;
}
