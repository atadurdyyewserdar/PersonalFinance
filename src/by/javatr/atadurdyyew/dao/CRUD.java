package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.exception.DAOException;

import java.util.List;

public interface CRUD<T> {
    T find(int id) throws DAOException;
    List<T>getAll() throws DAOException;
    void update(T data) throws DAOException;
    void delete(T data) throws DAOException;
    void create(T data) throws DAOException;
    int findMaxId() throws DAOException;
}