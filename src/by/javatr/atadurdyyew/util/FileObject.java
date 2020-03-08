package by.javatr.atadurdyyew.util;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class FileObject{
    public static Object readObject(String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        return objectInputStream.readObject();
    }

    public static void WriteObject(Object data, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
    }
}
