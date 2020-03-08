package by.javatr.project.controllers.commands;

import by.javatr.project.exceptions.controllerexception.ControllerException;

public interface Command {
    /**
     * @param request - selected task from menu
     * @return result of execution
     * @throws ControllerException
     */
    String execute(String request) throws ControllerException;

}
