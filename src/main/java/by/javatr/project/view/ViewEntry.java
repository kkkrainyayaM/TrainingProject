package by.javatr.project.view;

import by.javatr.project.controller.Controller;
import by.javatr.project.exception.controllerexception.ControllerException;
import by.javatr.project.exception.viewexception.ViewException;

import java.util.Scanner;

public class ViewEntry extends View {
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
                break;
            }
            default: {
                System.out.println( "Повторите ввод!" );
            }
        }
        return selectedCommand;
    }

    public void show() throws ViewException {
        System.out.println( getMenuItems() );
        Scanner scanner = new Scanner( System.in );
        Controller controller = new Controller();
        String command = getCommand( scanner.nextInt() );
        //System.out.println( controller.executeTask( command ) );
        try {
            controller.executeTask( command );
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
