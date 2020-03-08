package by.javatr.project.controllers;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.views.View;

public final class Controller {

    private final CommandProvider provider = new CommandProvider();
    private static Controller instance;

    private Controller() {
    }

    public static synchronized Controller getInstance() {
        if( instance == null ) {
            instance = new Controller();
        }
        return instance;
    }

    public View executeTask(String request) throws ControllerException {
        Command executionCommand = provider.getCommand( request );
        return executionCommand.execute( request );
    }
}
