package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        String result;

/*
        //Sign up new user
        result = controller.executeTask("sign_up user user");
        System.out.println("sign_up: " + result);

        //Login to system
        result = controller.executeTask("log_in admin admin");
        System.out.println("log_in: " + result);

        //Checking balance
        result = controller.executeTask("select_balance 1");
        System.out.println("Balance: " + result);

        //Operation expense (balance is 0)
        result = controller.executeTask("create_operation 1 -1000 RELAX");
        System.out.println("Operation expense result: " + result);

        //Operation income
        result = controller.executeTask("create_operation 1 1000 SALARY");
        System.out.println("Operation income result: " + result);

        //Operation expense
        result = controller.executeTask("create_operation 1 -50 RELAX");
        System.out.println("Operation expense result: " + result);

        //Show operation income
        result = controller.executeTask("select_operation_income 1");
        System.out.println("Select operation income: " + result);

        //Show operation expense
        result = controller.executeTask("select_operation_expense 1");
        System.out.println("Select operation expense: " + result);

        //Show operation expense
        result = controller.executeTask("select_operation_all 1");
        System.out.println("Select operation all: " + result);

        //Delete operation
        result = controller.executeTask("delete_operation 1");
        System.out.println("Delete result: " + result);
        result = controller.executeTask("select_operation_all 1");
        System.out.println("After delete: " + result);

        //Show balance
        result = controller.executeTask("select_balance 1");
        System.out.println("Select balance: " + result);

        //Delete operation
        result = controller.executeTask("delete_operation 1");
        System.out.println("Delete result: " + result);
*/
        while (true) {
            System.out.println("1) Log in");
            System.out.println("2) Sign up");
            System.out.println("3) Exit");
        }
    }
}
