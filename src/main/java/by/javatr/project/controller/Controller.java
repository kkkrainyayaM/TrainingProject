package by.javatr.project.controller;

import by.javatr.project.controller.command.Command;

public final class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        Command executionCommand;
        executionCommand = provider.getCommand( request);
        return executionCommand.execute( request );
    }
}
