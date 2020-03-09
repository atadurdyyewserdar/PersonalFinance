package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        String result;
        result = controller.executeTask("sign_up login=user&password=user");
        System.out.println(result);
        result = controller.executeTask("log_in login=admin&password=admin");
        System.out.println(result);
        result = controller.executeTask("log_in login=user&password=user");
        System.out.println(result);
        result = controller.executeTask("operation 1 10000 business");
        System.out.println(result);
        result = controller.executeTask("operation 1 10000 salary");
        System.out.println(result);
        result = controller.executeTask("operation 1 -5000 Relax");
        System.out.println(result);
        result = controller.executeTask("sign_up login=user&password=user");
        System.out.println(result);
        result = controller.executeTask("operation 1 10000 salary");
        System.out.println(result);
        result = controller.executeTask("operation 1 -5000 Relax");
        System.out.println(result);
    }
}
