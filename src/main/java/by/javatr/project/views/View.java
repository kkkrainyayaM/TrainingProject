package by.javatr.project.views;

import by.javatr.project.controllers.Controller;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.viewexception.ViewException;

import java.util.Scanner;

public abstract class View {

    protected abstract String getCommand(int selectedOperation);

    protected abstract String getMenuItems();

    private static Scanner scanner = new Scanner( System.in );

    public void show() throws ViewException {
        try {
            String command;
            System.out.println( getMenuItems() );
            do {
                command = getCommand( scanner.nextInt() );
            } while (command == null);

            if( !command.equals( "exit" ) ) {
                Main.ACTIVE_VIEW = Controller.getInstance().executeTask( command );
            }
        }
        catch (ControllerException e) {
            throw new ViewException( "Error in execution of task", e );
        }
    }
}
