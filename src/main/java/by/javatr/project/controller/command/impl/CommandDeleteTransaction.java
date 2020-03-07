package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Session;
import by.javatr.project.entity.UserType;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewDelete;

public class CommandDeleteTransaction implements Command {
    @Override
    public String execute(String request) {
        int id;
        if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
            CommandGetTransactions commandGetTransactions = new CommandGetTransactions();
            commandGetTransactions.execute( request );
        }
        else {
            CommandGetUserTrans commandGetUserTrans = new CommandGetUserTrans();
            commandGetUserTrans.execute( request );
        }
        ViewDelete viewDelete = new ViewDelete();
        viewDelete.show();
        id = viewDelete.getId();
        ServiceFactory.getInstance().getTransactionService().deleteTransaction( id );
        return "Транзакция удалена!";
    }
}
