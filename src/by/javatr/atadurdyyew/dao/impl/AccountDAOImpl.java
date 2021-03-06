package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.dao.convertor.AccountConvertor;
import by.javatr.atadurdyyew.dao.AccountDAO;
import by.javatr.atadurdyyew.exception.ConvertorException;
import by.javatr.atadurdyyew.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    public static final String FILE_NAME = "resources\\accounts.txt";
    public static final String FILE_NAME_TEMP = "resources\\accountsTemp.txt";

    @Override
    public Account find(int id) throws DAOException {
        Account account = null;
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = br.readLine()) != null) {
                Account account1 = AccountConvertor.convert(record);
                if (account1.getAccountId() == id) {
                    account = account1;
                }
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return account;
    }

    @Override
    public List<Account> getAll() throws DAOException {
        List<Account> accounts = new ArrayList<>();
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = bf.readLine()) != null) {
                accounts.add(AccountConvertor.convert(record));
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return accounts;
    }

    @Override
    public void update(Account data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME_TEMP);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_TEMP))) {
            String record;
            while ((record = br.readLine()) != null) {
                Account account = AccountConvertor.convert(record);
                if (account.getAccountId() == data.getAccountId()) {
                    bw.write(AccountConvertor.convert(data));
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
    public void delete(Account data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME_TEMP);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_TEMP))) {
            String record;
            while ((record = br.readLine()) != null) {
                if (record.contains(Integer.toString(data.getAccountId()))) {
                    continue;
                }
                bw.write(record);
                bw.flush();
                bw.newLine();
            }
        } catch (IOException e) {
            throw new DAOException("Error while writing account to file", e);
        }
        java.io.File file = new File(FILE_NAME);
        java.io.File fileTemp = new File(FILE_NAME_TEMP);
        file.delete();
        fileTemp.renameTo(file);
    }

    @Override
    public void create(Account data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));) {
            data.setAccountId(findMaxId() + 1);
            bw.write(AccountConvertor.convert(data));
            bw.flush();
            bw.newLine();
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing account to file", e);
        }
    }

    @Override
    public int findMaxId() throws DAOException {
        List<Account> accounts = getAll();
        int max = 0;
        for (Account account : accounts) {
            if (account.getAccountId() > max) {
                max = account.getAccountId();
            }
        }
        return max;
    }

    @Override
    public Account findByUserId(int id) throws DAOException {
        List<Account> accounts = getAll();
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
