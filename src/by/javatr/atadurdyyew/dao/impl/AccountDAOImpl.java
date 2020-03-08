package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.convertor.AccountConvertor;
import by.javatr.atadurdyyew.convertor.UserConvertor;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.dao.GenericDAO;
import by.javatr.atadurdyyew.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    public static final String FILE_NAME = "resources/accounts.txt";
    public static final String FILE_NAME_TEMP = "resources/accounts.txt";

    @Override
    public Account get(Account data) throws DAOException {
        BufferedReader br;
        File file;
        Account account = null;
        try {
            file = new File(FILE_NAME);
            if (!file.exists())
            {
                file.createNewFile();
            }
            br = new BufferedReader( new FileReader(FILE_NAME) );
            String record;
            while( ( record = br.readLine() ) != null ) {
                Account account1 = AccountConvertor.convert(record);
                if (account.getAccountId() == data.getAccountId())
                {
                    account = account1;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return account;
    }

    @Override
    public List<Account> getAll() throws DAOException {
        List<Account> accounts = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME));
            String record;
            while ((record = bf.readLine()) != null) {
                accounts.add(AccountConvertor.convert(record));
            }
        } catch (IOException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return accounts;
    }

    @Override
    public void update(Account data) throws DAOException {
        try {
            File fileTemp = new File(FILE_NAME_TEMP);
            File file = new File(FILE_NAME);
            if (!fileTemp.exists()) {
                fileTemp.createNewFile();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp));
            String record;
            while ((record = br.readLine()) != null) {
                if (record.contains(Integer.toString(data.getAccountId()))) {
                    bw.write(AccountConvertor.convert(data));
                } else {
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
    public void delete(Account data) throws DAOException {
        try {
            File fileTemp = new File(FILE_NAME_TEMP);
            File file = new File(FILE_NAME);
            if (!fileTemp.exists()) {
                fileTemp.createNewFile();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp));
            String record;
            while ((record = br.readLine()) != null) {
                if (record.contains(Integer.toString(data.getAccountId()))) {
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
            throw new DAOException("Error while writing account to file", e);
        }
    }

    @Override
    public void create(Account data) throws DAOException {
        BufferedWriter bw;
        File file;
        try {
            file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write(AccountConvertor.convert(data));
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new DAOException("Error while writing account to file", e);
        }
    }

    @Override
    public Account findByUserId(int id) throws DAOException {
        List<Account>accounts = getAll();
        Account result = null;
        for (Account account : accounts) {
            if (account.getUserId() == id) {
                result = account;
                break;
            }
        }
        return result;
    }
}
