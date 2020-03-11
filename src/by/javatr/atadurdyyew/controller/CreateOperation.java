package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

import java.math.BigDecimal;

public class CreateOperation implements Command {
    @Override
    public String execute(String command) {
        String[] data = command.split(" ");
        OperationService operationService = ServiceFactory.getInstance().getOperationService();
        String result;
        try {
            if (operationService.operation(Integer.parseInt(data[1]), new BigDecimal(data[2]), data[3])) {
                result = "Operation successfully completed";
            } else {
                result = "Wrong amount or wrong operation";
            }
        } catch (ServiceException e) {
            result = "Error acquired while operation expense";
        }
        return result;
    }
}
