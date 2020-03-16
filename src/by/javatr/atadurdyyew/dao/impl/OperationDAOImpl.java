package by.javatr.atadurdyyew.dao.impl;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.dao.convertor.OperationConvertor;
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
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        Operation operation = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));) {
            String record;
            while ((record = br.readLine()) != null) {
                Operation operation1 = OperationConvertor.convert(record);
                if (operation1.getId() == id) {
                    operation = operation1;
                }
            }
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        return operation;
    }

    @Override
    public List<Operation> getAll() throws DAOException {
        List<Operation> operations = new ArrayList<>();
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME))) {
            String record;
            while ((record = bf.readLine()) != null) {
                operations.add(OperationConvertor.convert(record));
            }
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
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME_TEMP);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_TEMP))) {
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
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing to file", e);
        }
        java.io.File file = new File(FILE_NAME);
        java.io.File fileTemp = new File(FILE_NAME_TEMP);
        file.delete();
        fileTemp.renameTo(file);
    }

    @Override
    public void delete(Operation data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME_TEMP);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_TEMP))) {
            File fileTemp = new File(FILE_NAME_TEMP);
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
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing account to file", e);
        }
        java.io.File file = new File(FILE_NAME);
        java.io.File fileTemp = new File(FILE_NAME_TEMP);
        file.delete();
        fileTemp.renameTo(file);
    }

    @Override
    public void create(Operation data) throws DAOException {
        if (data == null) {
            throw new DAOException("Data is null");
        }
        by.javatr.atadurdyyew.dao.util.File.createIfNoExists(FILE_NAME);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            data.setId(findMaxId() + 1);
            bw.write(OperationConvertor.convert(data));
            bw.flush();
            bw.newLine();
        } catch (IOException | ConvertorException e) {
            throw new DAOException("Error while writing account to file", e);
        }
    }
}
