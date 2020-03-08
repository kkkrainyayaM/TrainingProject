package by.javatr.project.controllers.commands;

import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.views.View;

public interface Command {
    /**
     * @param request - selected task from menu
     * @return result of execution
     * @throws ControllerException
     */
    View execute(String request) throws ControllerException;

}
