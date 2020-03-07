package by.javatr.project.views;

import by.javatr.project.controllers.Controller;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.viewexception.ViewException;

import java.util.Scanner;

public class ViewMenuAdmin extends View {
    @Override
    protected String getCommand(int selectedOperation) {
        String selectedCommand = null;
        switch (selectedOperation) {
            case 1: {
                selectedCommand = "get_users";
                break;
            }
            case 2: {
                selectedCommand = "delete_user";
                break;
            }
            case 3: {
                selectedCommand = "get_transactions";
                break;
            }
            case 4: {
                selectedCommand = "delete_transaction";
                break;
            }
            case 5: {
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
        try {
            controller.executeTask( command );
        }
        catch (ControllerException e) {
            throw new ViewException( "Error in execution of task", e );
        }
        //System.out.println( controllers.executeTask( commands ) );
    }


    @Override
    protected String getMenuItems() {
        return "1.Все пользователи\n2.Удалить пользователя\n3.Все транзакции\n4.Удалить транзакцию\n5.Выход";
    }

}
