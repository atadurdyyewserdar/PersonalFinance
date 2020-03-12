package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.convertor.UserConvertor;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class SignUp implements Command {
    @Override
    public String execute(String command) {
        String[] commands = command.split(" ");
        String login = commands[1];
        String password = commands[2];
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        String result;
        User user;

        try {
            if ((user = clientService.signUp(login, password)) != null) {
                result = String.valueOf(user.getId());
            } else {
                result = "Login already exists";
            }
        } catch (ServiceException e) {
            result = "Error acquired while signing up user";
        }
        return result;
    }
}
