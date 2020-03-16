package by.javatr.atadurdyyew.dao.util;

import by.javatr.atadurdyyew.exception.DAOException;

import java.io.IOException;

public class File {
    public static void createIfNoExists(String fileName) throws DAOException {
        java.io.File file = new java.io.File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new DAOException("Error while creating file", e);
            }
        }
    }
}
