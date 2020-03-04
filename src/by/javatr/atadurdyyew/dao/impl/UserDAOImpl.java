package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.util.FileLogic;
import by.javatr.atadurdyyew.exception.DAOException;

import java.util.List;

public class UserDAOImpl implements GenericDAO<User> {
    @Override
    public User get(int id) throws DAOException {
        return null;
    }

    @Override
    public List<User> getAll() throws DAOException {
        return null;
    }

    @Override
    public User update(User data) throws DAOException {
        return null;
    }

    @Override
    public void delete(User data) throws DAOException {

    }

    @Override
    public User create(User data) throws DAOException {
        data.setId((int)(Math.random() * 3));
        FileLogic fileLogic = new FileLogic();
        fileLogic.writeToFile(data);
        return data;
    }
}
