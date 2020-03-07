package by.javatr.project.controller.command;

import by.javatr.project.exception.controllerexception.ControllerException;

public interface Command {

    String execute(String request) throws ControllerException;

}
