package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ControllerException;

final public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private char paramDelimeter = ' ';

    public String executeTask(String request) throws ControllerException {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
