package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.exception.DAOException;

public interface OperationDAO extends CRUD<Operation> {
    int findMaxId() throws DAOException;
}
