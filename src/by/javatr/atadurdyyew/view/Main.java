package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.controller.Controller;
import by.javatr.atadurdyyew.convertor.UserConvertor;
import by.javatr.atadurdyyew.scanner.DataScanner;

import javax.xml.crypto.Data;

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

        int choice = 0;

        while (choice != 3) {
            System.out.println("1) Log in");
            System.out.println("2) Sign up");
            System.out.println("3) Exit");
            choice = DataScanner.enterIntFromConsole();
            switch (choice) {
                case 1: {
                    String login, password;
                    System.out.print("Enter login: ");
                    login = DataScanner.enterStringFromConsole();
                    System.out.print("Enter password");
                    password = DataScanner.enterStringFromConsole();
                    String request = "log_in " + login + " " + password;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    if (!result.equals("Wrong login or password")) {
                        System.out.println("===============================");
                        User user = UserConvertor.convert(result);
                    }
                    break;
                }
                case 2: {
                    String newLogin, newPassword;
                    System.out.print("Enter a new login: ");
                    newLogin = DataScanner.enterStringFromConsole();
                    System.out.print("Enter a new password");
                    newPassword = DataScanner.enterStringFromConsole();
                    String request = "sign_up " + newLogin + " " + newPassword;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                default:
                    break;
            }
        }
    }
}
