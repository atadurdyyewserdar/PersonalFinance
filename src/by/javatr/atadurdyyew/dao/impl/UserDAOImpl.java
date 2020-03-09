package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.convertor.UserConvertor;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.dao.UserDAO;
import by.javatr.atadurdyyew.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public final static String FILE_NAME = "resources/users.txt";
    public final static String FILE_NAME_TEMP = "resources/usersTemp.txt";

    @Override
    public User get(User data) throws DAOException {
        BufferedReader br;
        File file;
        User user = null;
        try {
            file = new File(FILE_NAME);
            if (!file.exists())
            {
                file.createNewFile();
            }
            br = new BufferedReader( new FileReader(FILE_NAME) );
            String record;
            while( ( record = br.readLine() ) != null ) {
                User user2 = UserConvertor.convert(record);
                if (user2.getId() == data.getId())
                {
                    user = user2;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return user;
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User>users = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists())
            {
                file.createNewFile();
            }
            BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME));
            String record;
            while ((record = bf.readLine()) != null){
                users.add(UserConvertor.convert(record));
            }
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return users;
    }

    @Override
    public void update(User data) throws DAOException {
        try {
            File fileTemp = new File(FILE_NAME_TEMP);
            File file = new File(FILE_NAME);
            if (!fileTemp.exists())
            {
                fileTemp.createNewFile();
            }
            if (!file.exists())
            {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp));
            String record;
            while ((record = br.readLine()) != null)
            {
                if (record.contains(Integer.toString(data.getId())))
                {
                    bw.write(UserConvertor.convert(data));
                }
                else {
                    bw.write(record);
                }
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
            file.delete();
            fileTemp.renameTo(file);
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
    }

    @Override
    public void delete(User user) throws DAOException {
        try {
            File fileTemp = new File(FILE_NAME_TEMP);
            File file = new File(FILE_NAME);
            if (!fileTemp.exists())
            {
                fileTemp.createNewFile();
            }
            if (!file.exists())
            {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp));
            String record;
            while ((record = br.readLine()) != null)
            {
                if (record.contains(Integer.toString(user.getId())))
                {
                    continue;
                }
                bw.write(record);
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
            file.delete();
            fileTemp.renameTo(file);
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
    }

    @Override
    public void create(User data) throws DAOException {
        BufferedWriter bw;
        File file;
        try {
            file = new File(FILE_NAME);
            if (!file.exists())
            {
                file.createNewFile();
            }
            bw = new BufferedWriter( new FileWriter(FILE_NAME,true) );
            bw.write(UserConvertor.convert(data));
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
    }

    @Override
    public int findMaxId() throws DAOException {
        return 0;
    }

    public User findByLogin(String login) throws DAOException{
        List<User>userList = getAll();
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
