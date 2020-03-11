package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.AccountService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class SelectBalance implements Command{
    @Override
    public String execute(String command) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();
        String[] strings = command.split(" ");
        String result;
        try {
            result = String.valueOf(accountService.getBalance(Integer.parseInt(strings[1])));
        } catch (ServiceException e) {
            result = "Error";
        }
        return  result;
    }
}
