package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Session;
import by.javatr.project.entity.UserType;
import by.javatr.project.exception.controllerexception.ControllerException;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewDelete;

public class DeleteTransaction implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        int id;
        if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
            GetTransactions getTransactions = new GetTransactions();
            getTransactions.execute( request );
        }
        else {
            GetUserTrans getUserTrans = new GetUserTrans();
            getUserTrans.execute( request );
        }
        ViewDelete viewDelete = new ViewDelete();
        viewDelete.show();
        id = viewDelete.getId();
        try {
            ServiceFactory.getInstance().getTransactionService().deleteTransaction( id );
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't delete transaction with id=" + id, e );
        }
        return "Транзакция удалена!";
    }
}
