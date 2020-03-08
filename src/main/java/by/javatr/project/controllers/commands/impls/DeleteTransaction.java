package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.UserType;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewDelete;
import by.javatr.project.views.ViewMenuAdmin;
import by.javatr.project.views.ViewMenuUser;

public class DeleteTransaction implements Command {
    @Override
    public View execute(String request) throws ControllerException {
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
            if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
                return new ViewMenuAdmin();
            }
            else {
                return new ViewMenuUser();
            }
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't delete transaction with id=" + id, e );
        }
    }
}
