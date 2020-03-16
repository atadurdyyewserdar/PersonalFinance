package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.dao.convertor.OperationConvertor;
import by.javatr.atadurdyyew.exception.ConvertorException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

import java.util.Iterator;

public class SelectOperationExpense implements Command {
    @Override
    public String execute(String command) {
        OperationService operationService = ServiceFactory.getInstance().getOperationService();
        String[] str = command.split(" ");
        int id = Integer.parseInt(str[1]);
        String result;
        try {
            Iterator<Operation> iterator = operationService.operationListExpense(id);
            result = OperationConvertor.convert(iterator);
        } catch (ServiceException | ConvertorException e) {
            result = "Error acquired while reading expense";
        }
        return result;
    }
}
