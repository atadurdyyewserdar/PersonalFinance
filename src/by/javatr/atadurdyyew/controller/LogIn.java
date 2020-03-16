package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.ServiceException;
import by.javatr.atadurdyyew.service.ClientService;
import by.javatr.atadurdyyew.service.factory.ServiceFactory;

public class LogIn implements Command {
    @Override
    public String execute(String command) {

        String[] commands = command.split(" ");
        String login = commands[1];
        String password = commands[2];

        String result;
        User user;
        ClientService clientService = ServiceFactory.getInstance().getClientService();

        try {
            if ((user = clientService.logIn(login, password)) != null) {
                result = String.valueOf(user.getId());
            } else {
                result = "Wrong login or password";
            }
        } catch (ServiceException e) {
            result = "Error acquired while logging in";
        }
        return result;
    }
}
