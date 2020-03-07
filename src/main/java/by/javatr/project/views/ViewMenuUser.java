package by.javatr.project.views;

import by.javatr.project.controllers.Controller;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.viewexception.ViewException;

import java.util.Scanner;

public class ViewMenuUser extends View {
    @Override
    protected String getCommand(int selectedOperation) {
        String selectedCommand = null;
        switch (selectedOperation) {
            case 1: {
                selectedCommand = "add_transaction";
                break;
            }
            case 2: {
                selectedCommand = "transactions_by_user";
                break;
            }
            case 3: {
                selectedCommand = "delete_transaction";
                break;
            }
            case 4: {
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
        return "1.Добавить транзакцию\n2.Мои транзакции\n3.Удалить транзакцию\n4.Выход";
    }
}
