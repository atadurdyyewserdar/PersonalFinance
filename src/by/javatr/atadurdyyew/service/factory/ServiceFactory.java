package by.javatr.atadurdyyew.service.factory;

import by.javatr.atadurdyyew.service.AccountService;
import by.javatr.atadurdyyew.service.UserService;
import by.javatr.atadurdyyew.service.impl.AccountServiceImpl;
import by.javatr.atadurdyyew.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static ServiceFactory instance = new ServiceFactory();

    AccountService accountService = new AccountServiceImpl();
    UserService userService = new UserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public UserService getUserService() {
        return userService;
    }
}
