package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;
import by.javatr.atadurdyyew.scanner.DataScanner;

import java.util.jar.JarOutputStream;

public class Main {

    static Controller controller = new Controller();

    public static void main(String[] args) {
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
                    System.out.print("Enter password: ");
                    password = DataScanner.enterStringFromConsole();
                    String request = "log_in " + login + " " + password;
                    result = controller.executeTask(request);
                    if (!result.equals("Wrong login or password")) {
                        userMenu(result);
                    }
                    break;
                }
                case 2: {
                    String newLogin, newPassword;
                    System.out.print("Enter a new login: ");
                    newLogin = DataScanner.enterStringFromConsole();
                    System.out.print("Enter a new password: ");
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

    public static void userMenu(String userId) {
        boolean exit = false;
        String request = "", result = "";
        request = "select_account " + userId;
        result = controller.executeTask(request);
        String accountId = result;
        int choice = 0;
        while (!exit) {
            System.out.println("=========================================");
            System.out.println("1) Show account information");
            System.out.println("2) Show Balance");
            System.out.println("3) Show all operations");
            System.out.println("4) Show only incomes");
            System.out.println("5) Show only expenses");
            System.out.println("6) Add operation");
            System.out.println("7) Delete operation");
            System.out.println("8) Exit");
            System.out.println("Your choice: ");
            choice = DataScanner.enterIntFromConsole();
            switch (choice) {
                case 1: {
                    request = "select_account " + userId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 2: {
                    request = "select_balance " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 3: {
                    request = "select_operation_all " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 4: {
                    request = "select_operation_income " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 5: {
                    request = "select_operation_expense " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 6: {
                    System.out.println("Enter amount: ");
                    String amount = DataScanner.enterStringFromConsole();
                    String description = DataScanner.enterStringFromConsole();
                    request = "create_operation " + accountId + " " + amount + " " + description;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 7: {
                    request = "select_operation_all " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    System.out.println("Enter operation id (only from history): ");
                    int opId = DataScanner.enterIntFromConsole();
                    request = "delete_operation " + opId;
                    result = controller.executeTask(request);
                    System.out.println(result);
                    break;
                }
                case 8:
                    exit = true;
            }
            System.out.println("=========================================");
        }
    }
}
