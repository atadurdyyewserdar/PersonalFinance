package by.javatr.atadurdyyew.controller;

import by.javatr.atadurdyyew.exception.ControllerException;

public interface Command {
    String execute(String command) throws ControllerException;
}
