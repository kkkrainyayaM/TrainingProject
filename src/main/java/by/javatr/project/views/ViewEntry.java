package by.javatr.project.views;

import by.javatr.project.controllers.Controller;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.viewexception.ViewException;

import java.util.Scanner;

public class ViewEntry extends View {

    private static Scanner scanner = new Scanner( System.in );

    @Override
    protected String getCommand(int selectedOperation) {
        String selectedCommand = null;
        switch (selectedOperation) {
            case 1: {
                selectedCommand = "sign_in";
                break;
            }
            case 2: {
                selectedCommand = "sign_up";
                break;
            }
            case 3: {
                selectedCommand = "exit";
                Main.ACTIVE_VIEW = null;
                break;
            }
            default: {
                System.out.println( "Повторите ввод!" );
            }
        }
        return selectedCommand;
    }

    public void show() throws ViewException {
        try {
            System.out.println( getMenuItems() );
            String command = getCommand( scanner.nextInt() );
            if( !command.equals( "exit" ) ) {
                Main.ACTIVE_VIEW = Controller.getInstance().executeTask( command );
            }
        }
        catch (ControllerException e) {
            throw new ViewException( "Error in execution of task", e );
        }
    }


    @Override
    protected String getMenuItems() {
        return "1.Войти\n2.Зарегестироваться\n3.Выход";
    }
}
