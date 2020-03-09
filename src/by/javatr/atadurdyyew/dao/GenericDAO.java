package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.exception.DAOException;

import java.util.List;

public interface GenericDAO<T> {
    T get(T data) throws DAOException;
    List<T>getAll() throws DAOException;
    void update(T id) throws DAOException;
    void delete(T id) throws DAOException;
    void create(T id) throws DAOException;
    int findMaxId() throws DAOException;
}