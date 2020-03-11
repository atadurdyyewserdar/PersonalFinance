package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.convertor.AccountConvertor;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.AccountService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class SelectAccount implements Command {
    @Override
    public String execute(String command) {
        String[] commands = command.split(" ");
        int user_id = Integer.parseInt(commands[1]);
        AccountService accountService = ServiceFactory.getInstance().getAccountService();
        String result;
        try {
            Account account = accountService.getMyAccount(user_id);
            if (account != null) {
                result = AccountConvertor.convert(accountService.getMyAccount(user_id));
            } else {
                result = "Account not found";
            }
        } catch (ServiceException e) {
            result = "Error acquired while finding account";
        }
        return result;
    }
}
