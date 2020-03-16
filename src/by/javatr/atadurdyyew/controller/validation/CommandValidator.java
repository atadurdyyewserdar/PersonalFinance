package by.javatr.atadurdyyew.controller.validation;

import by.javatr.atadurdyyew.controller.entity.CommandName;

public class CommandValidator {
    public static boolean validate(String command) {
        boolean res = false;
        if (command != null) {
            for (CommandName commandName : CommandName.values()) {
                if (command.equals(String.valueOf(commandName))) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
