package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;
import by.javatr.atadurdyyew.exception.ControllerException;

public class Main {
    public static void main(String[] args) {
/*
        String com = "sign_up login=admin&password=admin";
        int i1 = com.indexOf('=');
        String login = com.substring(i1 + 1, com.indexOf('&'));
        int i2 = com.lastIndexOf('=');
        String password = com.substring(i2 + 1);

        System.out.println("login: " + login);
        System.out.println("password: " + password);
*/
        Controller controller = new Controller();
        try {
            String result = controller.executeTask("sign_up login=admin&password=admin");
            System.out.println(result);
        } catch (ControllerException e) {
            e.printStackTrace();
        }

    }
}
