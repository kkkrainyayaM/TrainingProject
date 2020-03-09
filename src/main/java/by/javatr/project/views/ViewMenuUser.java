package by.javatr.project.views;

import by.javatr.project.exceptions.viewexception.ViewException;

import static by.javatr.project.validations.Validator.isItemNum;

public class ViewMenuUser extends View {

    @Override
    protected String getCommand(int selectedOperation) {
        String selectedCommand = null;
        if( isItemNum( selectedOperation ) ) {
            switch (selectedOperation) {
                case 1:{
                    selectedCommand = "get_balance";
                    break;
                }
                case 2: {
                    selectedCommand = "add_transaction";
                    break;
                }
                case 3: {
                    selectedCommand = "transactions_by_user";
                    break;
                }
                case 4: {
                    selectedCommand = "delete_transaction";
                    break;
                }
                case 5: {
                    selectedCommand = "exit";
                    Main.ACTIVE_VIEW = null;
                    break;
                }
                case 6:{
                    selectedCommand = "get_last_transaction";
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
        return "1.Баланс\n2.Добавить транзакцию\n3.Мои транзакции\n4.Удалить транзакцию\n5.Последняя транзакция\n5.Выход";
    }
}
