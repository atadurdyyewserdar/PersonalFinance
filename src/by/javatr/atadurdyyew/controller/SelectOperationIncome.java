package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.convertor.OperationConvertor;
import by.javatr.atadurdyyew.exception.ConvertorException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.OperationService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

import java.util.Iterator;

public class SelectOperationIncome implements Command {
    @Override

    public String execute(String command) {
        OperationService operationService = ServiceFactory.getInstance().getOperationService();
        String[] str = command.split(" ");
        int id = Integer.parseInt(str[1]);
        String result;
        try {
            Iterator<Operation> operationIterator = operationService.operationListIncome(id);
            result = OperationConvertor.convert(operationIterator);
        } catch (ServiceException | ConvertorException e) {
            result = "Error acquired while reading income";
        }
        return result;
    }
}
