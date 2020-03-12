package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.convertor.AccountConvertor;
import by.javatr.atadurdyyew.convertor.OperationConvertor;
import by.javatr.atadurdyyew.dao.OperationDAO;
import by.javatr.atadurdyyew.exception.ConvertorException;
import by.javatr.atadurdyyew.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDAOImpl implements OperationDAO {
    public static final String FILE_NAME = "resources/operations.txt";
    public static final String FILE_NAME_TEMP = "resources/operationsTemp.txt";

    @Override
    public int findMaxId() throws DAOException {
        List<Operation> operations = getAll();
        int max = 0;
        for (Operation operation : operations) {
            if (operation.getId() > max) {
                max = operation.getId();
            }
        }
        return max;
    }

    @Override
    public Operation find(int id) throws DAOException {
        BufferedReader br;
        File file;
        Operation operation = null;
        try {
            file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(FILE_NAME));
            String record;
            while ((record = br.readLine()) != null) {
                Operation operation1 = OperationConvertor.convert(record);
                if (operation1.getId() == id) {
                    operation = operation1;
                }
            }
            br.close();
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return operation;
    }

    @Override
    public List<Operation> getAll() throws DAOException {
        List<Operation> operations = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME));
            String record;
            while ((record = bf.readLine()) != null) {
                operations.add(OperationConvertor.convert(record));
            }
            bf.close();
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return operations;
    }

    @Override
    public void update(Operation data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
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
                Operation operation = OperationConvertor.convert(record);
                if (data.getId() == operation.getId()) {
                    bw.write(OperationConvertor.convert(data));
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
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
    }

    @Override
    public void delete(Operation data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
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
                Operation operation = OperationConvertor.convert(record);
                if (operation.getId() == data.getId()) {
                    System.out.println("From DAO data: " + data);
                    System.out.println("From DAO operation" + operation);
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
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing account to file", e);
        }
    }

    @Override
    public void create(Operation data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        BufferedWriter bw;
        File file;
        try {
            file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            data.setId(findMaxId() + 1);
            bw.write(OperationConvertor.convert(data));
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing account to file", e);
        }
    }
}
