package by.javatr.atadurdyyew.view;

import by.javatr.atadurdyyew.controller.Controller;
import by.javatr.atadurdyyew.view.scanner.DataScanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    static Controller controller = new Controller();

    public static void main(String[] args) {
        String result;
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
                    } else {
                        System.out.println(result);
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
                    System.out.println(ANSI_BLACK + "ID: " + result + ANSI_RESET);
                    break;
                }
                case 2: {
                    request = "select_balance " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(ANSI_BLACK + "Balance: " + result + ANSI_RESET);
                    break;
                }
                case 3: {
                    request = "select_operation_all " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(ANSI_BLACK + result + ANSI_RESET);
                    break;
                }
                case 4: {
                    request = "select_operation_income " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(ANSI_BLACK + result + ANSI_RESET);
                    break;
                }
                case 5: {
                    request = "select_operation_expense " + accountId;
                    result = controller.executeTask(request);
                    System.out.println(ANSI_BLACK + result + ANSI_RESET);
                    break;
                }
                case 6: {
                    System.out.println("Enter amount: ");
                    String amount = DataScanner.enterStringFromConsole();
                    System.out.println("Enter description: ");
                    String description = DataScanner.enterStringFromConsole();
                    request = "create_operation " + accountId + " " + amount + " " + description;
                    result = controller.executeTask(request);
                    System.out.println(ANSI_BLACK + result + ANSI_RESET);
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
                    System.out.println(ANSI_BLACK + result + ANSI_RESET);
                    break;
                }
                case 8:
                    exit = true;
            }
        }
    }
}
