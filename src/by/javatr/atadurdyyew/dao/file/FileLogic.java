package by.javatr.atadurdyyew.dao.file;

import by.javatr.atadurdyyew.exception.DAOException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileLogic {
    public void writeToFile(String data) throws DAOException {
        if (data == null){
            throw new DAOException("Data is null");
        }
        try {
            BufferedWriter bufferedWriter =  Files.newBufferedWriter(
                    Paths.get("resources/users.txt"),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(data);
            printWriter.close();
        } catch (IOException e) {
            throw new DAOException("File exception", e);
        }
    }
}
