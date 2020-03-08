package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ControllerException;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class LogIn implements Command {
    @Override
    public String execute(String command) throws ControllerException {
        int i1 = command.indexOf('=');
        String login = command.substring(i1 + 1, command.indexOf('&'));
        int i2 = command.lastIndexOf('=');
        String password = command.substring(i2 + 1);
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        String result;
        try {
            if (clientService.logIn(login, password))
            {
                result = "successful";
            }
            else {
                result = "login or password is wrong";
            }
        } catch (ServiceException e) {
            result = "Error during log in ";
        }
        return result;
    }
}
