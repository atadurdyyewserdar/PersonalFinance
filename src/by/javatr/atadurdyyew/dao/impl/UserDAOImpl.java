package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.dao.convertor.UserConvertor;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.UserDAO;
import by.javatr.atadurdyyew.exception.ConvertorException;
import by.javatr.atadurdyyew.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public final static String FILE_NAME = "resources/users.txt";
    public final static String FILE_NAME_TEMP = "resources/usersTemp.txt";

    @Override
    public User find(int id) throws DAOException {
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        User user = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = br.readLine()) != null) {
                User user2 = UserConvertor.convert(record);
                if (id == user2.getId()) {
                    user = user2;
                }
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return user;
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME));) {
            String record;
            while ((record = bf.readLine()) != null) {
                users.add(UserConvertor.convert(record));
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return users;
    }

    @Override
    public void update(User data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_TEMP));
        ) {
            String record;
            while ((record = br.readLine()) != null) {
                User user = UserConvertor.convert(record);
                if (data.getId() == user.getId()) {
                    bw.write(UserConvertor.convert(data));
                } else {
                    bw.write(record);
                }
                bw.flush();
                bw.newLine();
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        java.io.File file = new File(FILE_NAME);
        java.io.File fileTemp = new File(FILE_NAME_TEMP);
        file.delete();
        fileTemp.renameTo(file);
    }

    @Override
    public void delete(User data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME_TEMP);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_TEMP))) {
            String record;
            while ((record = br.readLine()) != null) {
                User user = UserConvertor.convert(record);
                if (data.getId() == user.getId()) {
                    continue;
                }
                bw.write(record);
                bw.flush();
                bw.newLine();
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        java.io.File file = new File(FILE_NAME);
        java.io.File fileTemp = new File(FILE_NAME_TEMP);
        file.delete();
        fileTemp.renameTo(file);
    }

    @Override
    public void create(User data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));) {
            int id = findMaxId() + 1;
            data.setId(id);
            bw.write(UserConvertor.convert(data));
            bw.flush();
            bw.newLine();
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
    }

    @Override
    public int findMaxId() throws DAOException {
        List<User> userList = getAll();
        int max = 0;
        for (User us : userList) {
            if (us.getId() > max) {
                max = us.getId();
            }
        }
        return max;
    }

    @Override
    public User findByLogin(String login) throws DAOException {
        if (login == null) {
            throw new DAOException("login is null");
        }
        List<User> userList = getAll();
        User result = null;
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                result = user;
                break;
            }
        }
        return result;
    }
}
