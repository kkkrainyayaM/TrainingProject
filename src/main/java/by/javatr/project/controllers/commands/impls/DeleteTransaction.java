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

    private static ViewDelete viewDelete = new ViewDelete();

    @Override
    public View execute(String request) throws ControllerException {
        boolean hasTransactions;
        if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
            hasTransactions = executeAdmin( request );
        }
        else {
            hasTransactions = executeUser( request );
        }
        if( hasTransactions ) {
            delete();
        }
        else {
            viewDelete.showEmptyTrans();
        }
        if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
            return new ViewMenuAdmin();
        }
        else {
            return new ViewMenuUser();
        }

    }

    private static boolean executeUser(String request) throws ControllerException {
        GetUserTrans getUserTrans = new GetUserTrans();
        getUserTrans.execute( request );
        return getUserTrans.hasTransactions();
    }

    private static boolean executeAdmin(String request) throws ControllerException {
        GetTransactions getTransactions = new GetTransactions();
        getTransactions.execute( request );
        return getTransactions.hasTransactions();
    }

    private static void delete() throws ControllerException {
        viewDelete.show();
        int id = viewDelete.getId();
        try {
            ServiceFactory.getInstance().getTransactionService().deleteTransaction( id );
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't delete transaction with id=" + id, e );
        }
        viewDelete.showResult();
    }
}
