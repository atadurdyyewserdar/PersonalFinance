package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.entity.CommandName;

import java.util.HashMap;
import java.util.Map;

final public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.LOG_IN, new LogIn());
        repository.put(CommandName.LOG_OUT, new LogOut());
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.OPERATION, new Operation());
    }

    Command getCommand(String name){
        CommandName commandName = null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }
        catch (IllegalArgumentException | NullPointerException ex){
            ex.printStackTrace();
        }
        return command;
    }
}
