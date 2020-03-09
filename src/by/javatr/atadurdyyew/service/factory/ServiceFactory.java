package by.javatr.atadurdyyew.service.factory;

import by.javatr.atadurdyyew.service.AccountService;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.impl.AccountServiceImpl;
import by.javatr.atadurdyyew.service.impl.ClientServiceImpl;
import by.javatr.atadurdyyew.service.impl.OperationServiceImpl;

public class ServiceFactory {
    public static ServiceFactory instance = new ServiceFactory();

    AccountService accountService = new AccountServiceImpl();
    ClientService clientService = new ClientServiceImpl();
    OperationService operationService = new OperationServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public OperationService getOperationService() {
        return operationService;
    }
}
