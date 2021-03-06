package by.javatr.atadurdyyew.dao;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.DAOException;

public interface UserDAO extends CRUD<User> {
    User findByLogin(String login) throws DAOException;
}
