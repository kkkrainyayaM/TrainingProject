package by.javatr.project.views;

import by.javatr.project.exceptions.viewexception.ViewException;

import static by.javatr.project.validations.Validator.isItemNum;

public class ViewEntry extends View {

    @Override
    protected String getCommand(int selectedOperation) {
        String selectedCommand = null;
        if( isItemNum( selectedOperation ) ) {
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
        }
        return selectedCommand;
    }

    public void show() throws ViewException {
       super.show();
    }


    @Override
    protected String getMenuItems() {
        return "1.Войти\n2.Зарегестироваться\n3.Выход";
    }
}
