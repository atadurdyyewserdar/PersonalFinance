package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        String result;
        /*result = controller.executeTask("sign_up login=user&password=user");
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
        result = controller.executeTask("balance 1");
        System.out.println(result);*/

        String request_sign_up = "sign_up login=user&password=user";
        String request_login = "log_in login=user&password=user";
        String request_select_operation_all = "select_operation all {account_id}";
        String request_select_operation_expense = "select_operation expense {account_id}";
        String request_select_operation_income = "select_operation income {account_id}";
        String request_select_balance = "select_balance" + "{account_id}";
        String request_delete_operation = "delete_operation {account_id}";
        String request_create_operation = "create_operation {account_id} {sum} {description}";
    }
}
