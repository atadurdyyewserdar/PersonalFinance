package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ControllerException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;
import by.javatr.atadurdyyew.service.impl.OperationServiceImpl;

import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Operation implements Command {
    @Override
    public String execute(String command) throws ControllerException {
        String[] data = command.split(" ");
        OperationService operationService = ServiceFactory.getInstance().getOperationService();
        String result;
        try {
            if (operationService.addFunds(Integer.parseInt(data[1]), new BigDecimal(data[2]), data[3]))
            {
                result = "successful";
            }
            else {
                result = "error";
            }
        } catch (ServiceException e) {
            result = "Error during signing up";
        }
        return result;
    }
}
