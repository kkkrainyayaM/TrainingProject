package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewMenuUser;
import by.javatr.project.views.ViewTransactions;

public class GetLastTrans implements Command {
    private static ViewTransactions viewTransactions = new ViewTransactions();

    @Override
    public View execute(String request) throws ControllerException {
        try {
            User user = Session.getInstance().getUser();
            Transaction transaction = ServiceFactory.getInstance()
                    .getTransactionService().getLastTransaction( user );
            viewTransactions.show( transaction.toString() );
            return new ViewMenuUser();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get transactions", e );
        }

    }
}
