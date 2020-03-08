package by.javatr.atadurdyyew.convertor;

import by.javatr.atadurdyyew.bean.User;

public class UserConvertor {
    public static String convert(User user) {
        return String.valueOf(user.getId()) +
                ',' +
                user.getLogin() +
                ',' +
                user.getPassword();
    }
    public static User convert(String data){
        String[] str = data.split(",");
        User user = new User();
        user.setId(Integer.parseInt(str[0]));
        user.setLogin(str[1]);
        user.setPassword(str[2]);
        return user;
    }
}
