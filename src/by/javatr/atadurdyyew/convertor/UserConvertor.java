package by.javatr.atadurdyyew.convertor;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.ConvertorException;

public class UserConvertor {
    public static String convert(User user) throws ConvertorException {
        if (user == null) {
            throw new ConvertorException("Data is null, can't convert");
        }
        return String.valueOf(user.getId()) +
                ',' +
                user.getLogin() +
                ',' +
                user.getPassword();
    }

    public static User convert(String data) throws ConvertorException {
        if (data == null) {
            throw new ConvertorException("Data is null, can't convert");
        }
        String[] str = data.split(",");
        if (str.length != 3) {
            throw new ConvertorException("Wring str, can't convert");
        }
        User user = new User();
        try {
            user.setId(Integer.parseInt(str[0]));
            user.setLogin(str[1]);
            user.setPassword(str[2]);
        } catch (NumberFormatException ex) {
            throw new ConvertorException("Error while converting data, wrong data", ex);
        }
        return user;
    }
}
