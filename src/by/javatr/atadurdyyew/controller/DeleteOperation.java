package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class DeleteOperation implements Command {
    @Override
    public String execute(String command) {
        String[] commands = command.split(" ");
        int id = Integer.parseInt(commands[1]);
        OperationService operationService = ServiceFactory.getInstance().getOperationService();
        String result;
        try {
            if (operationService.deleteOperation(id)) {
                result = "Operation successfully deleted";
            } else {
                result = "Operation wasn't deleted (check id)";
            }
        } catch (ServiceException e) {
            result = "Error acquired while deleting operation";
        }
        return result;
    }
}
