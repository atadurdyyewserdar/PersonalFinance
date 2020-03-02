package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;
import by.javatr.atadurdyyew.exception.ControllerException;


public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        try {
            String result = controller.executeTask("sign_up login=admin&password=admin");
            System.out.println(result);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }


}
