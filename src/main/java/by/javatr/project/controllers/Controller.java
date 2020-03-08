package by.javatr.project.controllers;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.exceptions.controllerexception.ControllerException;

public final class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) throws ControllerException {
        Command executionCommand;
        executionCommand = provider.getCommand( request );
        return executionCommand.execute( request );

    }
}
