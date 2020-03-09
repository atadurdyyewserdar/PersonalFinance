package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ControllerException;

public class LogOut implements Command {
    @Override
    public String execute(String command) throws ControllerException {
        return "success";
    }
}
