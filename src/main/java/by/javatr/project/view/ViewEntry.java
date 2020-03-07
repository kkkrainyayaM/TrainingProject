package by.javatr.project.view;

import by.javatr.project.controller.Controller;

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

    public void show() {
        System.out.println( getMenuItems() );
        Scanner scanner = new Scanner( System.in );
        Controller controller = new Controller();
        String command = getCommand( scanner.nextInt() );
        //System.out.println( controller.executeTask( command ) );
        controller.executeTask( command );
    }


    @Override
    protected String getMenuItems() {
        return "1.Войти\n2.Зарегестироваться\n3.Выход";
    }
}
