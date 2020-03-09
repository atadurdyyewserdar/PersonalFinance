package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.convertor.UserConvertor;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class LogIn implements Command {
    @Override
    public String execute(String command) {
        int i1 = command.indexOf('=');
        String login = command.substring(i1 + 1, command.indexOf('&'));
        int i2 = command.lastIndexOf('=');
        String password = command.substring(i2 + 1);
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        String result;
        User user;
        try {
            user = clientService.logIn(login, password);
            if (user != null){
                result = UserConvertor.convert(user) + " successfully logged in";
            }
            else{
                result = "wrong login or password";
            }
        } catch (ServiceException e) {
            result = "Error during log in Controller";
        }
        return result;
    }
}
