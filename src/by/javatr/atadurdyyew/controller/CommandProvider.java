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
        repository.put(CommandName.SELECT_BALANCE, new SelectBalance());
        repository.put(CommandName.SELECT_OPERATION_ALL, new SelectOperationAll());
        repository.put(CommandName.SELECT_OPERATION_EXPENSE, new SelectOperationExpense());
        repository.put(CommandName.SELECT_OPERATION_INCOME, new SelectOperationIncome());
        repository.put(CommandName.DELETE_OPERATION, new DeleteOperation());
        repository.put(CommandName.CREATE_OPERATION, new CreateOperation());
    }

    Command getCommand(String name){
        CommandName commandName;
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
