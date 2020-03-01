package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.exception.DAOException;

import java.util.List;

public interface GenericDAO<T> {
    T get(int id) throws DAOException;
    List<T>getAll() throws DAOException;
    T update(T data) throws DAOException;
    void delete(T data) throws DAOException;
    T create(T data) throws DAOException;
}
