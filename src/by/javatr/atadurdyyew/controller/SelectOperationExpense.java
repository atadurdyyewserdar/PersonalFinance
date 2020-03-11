package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class SelectOperationExpense implements Command{
    @Override
    public String execute(String command) {
        OperationService operationService = ServiceFactory.getInstance().getOperationService();
        String[] str = command.split(" ");
        int id = Integer.parseInt(str[1]);
        String result;
        try {
            result = operationService.operationList().toString();
        } catch (ServiceException e) {
            result = "Error reading expense";
        }
        return result;
    }
}
