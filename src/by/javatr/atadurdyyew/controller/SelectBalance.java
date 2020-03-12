package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.AccountService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

import java.math.BigDecimal;

public class SelectBalance implements Command {
    @Override
    public String execute(String command) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();
        String[] strings = command.split(" ");
        String result;
        try {
            int account_id = Integer.parseInt(strings[1]);
            BigDecimal bigDecimal = accountService.getBalance(account_id);
            if (bigDecimal == null) {
                result = "Account not found";
            } else {
                result = String.valueOf(bigDecimal);
            }
        } catch (ServiceException e) {
            result = "Error acquired while executing balance";
        }
        return result;
    }
}
