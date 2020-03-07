package by.javatr.project.controllers.commands;

import by.javatr.project.exceptions.controllerexception.ControllerException;

public interface Command {

    String execute(String request) throws ControllerException;

}
